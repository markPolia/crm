package com.powernode.web.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.io.IOException;

@WebFilter
public class DynamicResourceEncodingFilter extends CharacterEncodingFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String encoding = getEncoding();
        if (encoding != null) {
            if (isForceRequestEncoding() || request.getCharacterEncoding() == null) {
                request.setCharacterEncoding(encoding);
            }
            if (isForceResponseEncoding()) {
                if (!request.getServletPath().toLowerCase().endsWith(".html")) {
                    // 不为html资源时，不再设置响应浏览器的html的文件编码
                    response.setCharacterEncoding(encoding);
                }
            }
        }
        filterChain.doFilter(request, response);
    }
}
