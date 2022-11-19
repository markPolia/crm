package com.powernode.web.controller;

import com.powernode.web.domain.Activity;
import com.powernode.web.domain.AnonymousStructure;
import com.powernode.web.domain.User;
import com.powernode.web.service.ActivityRemarkService;
import com.powernode.web.service.ActivityService;
import com.powernode.web.service.UserService;
import com.powernode.web.util.DateTimeUtil;
import com.powernode.web.util.UUIDUtil;
import com.powernode.web.vo.PageInfo;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @ResponseBody
    @RequestMapping("/activity/getUserList")
    public List<User> activityUserList() {
        return userService.getAllUsers();
    }

    @ResponseBody
    @RequestMapping(value = "/activity/createMarkActivity", method = RequestMethod.POST)
    public AnonymousStructure activityCreateMarkActivity(HttpSession session, Activity activity) {
        activity.setId(UUIDUtil.generateUUID());
        activity.setCreateTime(DateTimeUtil.generateNowTime());
        activity.setCreateBy(((User) session.getAttribute("user")).getName());
        return new AnonymousStructure() {
            public boolean getSuccess() { return activityService.saveActivity(activity); }
        };
    }

    @ResponseBody
    @RequestMapping("/activity/activitiesList")
    public PageInfo<Activity> activitiesList(Integer pageNo, Integer pageSize, Activity activity) {
        return activityService.showActivitiesInPageInfo(pageSize * (pageNo - 1), pageSize, activity);
    }

    @ResponseBody
    @RequestMapping("/activity/deleteMarkActivity")
    public AnonymousStructure activityDeleteMarkActivity(@RequestParam("id") List<String> aids) {
        return new AnonymousStructure() {
            public boolean getSuccess() { return activityService.deleteActivity(aids); }
        };
    }

    @ResponseBody
    @RequestMapping("/activity/before/update_list_activity")
    public Map<String, Object> activityBeforeUpdate_list_activity(String id) {
        return activityService.showActivityWithDetailById(id);
    }

    @ResponseBody
    @RequestMapping("/activity/updateMarkActivity")
    public AnonymousStructure activityUpdateMarkActivity(Activity activity, HttpSession session) {
        activity.setEditTime(DateTimeUtil.generateNowTime());
        activity.setEditBy(((User) session.getAttribute("user")).getName());
        return new AnonymousStructure() {
            public boolean getSuccess() {
                return activityService.updateActivity(activity);
            }
        };
    }
}
