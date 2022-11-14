package com.powernode.web.controller;

import com.powernode.web.service.UserService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/settings/user")
public class IndexAction {
    @Resource(type = UserService.class)
    private UserService service;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public void index(HttpServletRequest request) {
        System.out.println("登陆ip地址：" + request.getRemoteAddr());
        System.out.println("index");
    }
}
