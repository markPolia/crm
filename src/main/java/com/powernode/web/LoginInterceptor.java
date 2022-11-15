package com.powernode.web;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component("loginInterceptor")
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (request.getSession().getAttribute("user") == null) {
            request.setAttribute("error", "登陆状态已过期，请重新登录！");
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return false;
        }
        return true;
    }
}
