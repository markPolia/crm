package com.powernode.web.controller;

import com.powernode.web.domain.Activity;
import com.powernode.web.domain.User;
import com.powernode.web.service.ActivityRemarkService;
import com.powernode.web.service.ActivityService;
import com.powernode.web.service.UserService;
import com.powernode.web.util.DateTimeUtil;
import com.powernode.web.util.UUIDUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/workbench")
public class WorkbenchAction {
    @Resource(type = ActivityRemarkService.class)
    private ActivityRemarkService activityRemarkService;

    @Resource(type = ActivityService.class)
    private ActivityService activityService;

    @Resource(type = UserService.class)
    private UserService userService;

    @RequestMapping(value = "/index")
    public String workbenchIndex() {
        return "workbench/index";
    }

    @RequestMapping("/main/index")
    public String mainIndex() {
        return "workbench/main/index";
    }

    @RequestMapping("/activity/detail")
    public String activityDetail() {
        return "workbench/activity/detail";
    }

    @RequestMapping("/activity/index")
    public String activityIndex() {
        return "workbench/activity/index";
    }

    @RequestMapping("/activity/getUserList")
    @ResponseBody
    public List<User> activityUserList() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/activity/createMarkActivity", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Boolean> activityCreateMarkActivity(HttpSession session, Activity activity) {
        activity.setId(UUIDUtil.generateUUID());
        activity.setCreateTime(DateTimeUtil.generateNowTime());
        activity.setCreateBy(((User) session.getAttribute("user")).getName());
        HashMap<String, Boolean> map = new HashMap<>();
        map.put("success", activityService.saveActivity(activity));
        return map;
    }
}
