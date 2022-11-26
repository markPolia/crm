package com.powernode.web.settings.web.controller;

import com.powernode.web.settings.domain.User;
import com.powernode.web.exception.UserException;
import com.powernode.web.settings.service.UserService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/settings/user", method = {RequestMethod.GET, RequestMethod.POST})
public class LoginAction {
    @Resource(type = UserService.class)
    private UserService service;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> login(String loginAct, String loginPwd, HttpServletRequest request, HttpSession session) {
        Map<String, Object> res = new HashMap<>(5);
        if (loginAct == null || loginPwd == null) {
            res.put("success", false);
            res.put("errorMsg", "错误的登陆方式");
            return res;
        }
        try {
            User user = service.login(loginAct, loginPwd, request.getRemoteAddr());
            session.setAttribute("user", user);
        } catch (UserException e) {
            res.put("success", false);
            res.put("errorMsg", e.getMessage());
            return res;
        }
        res.put("success", true);
        return res;
    }
}
