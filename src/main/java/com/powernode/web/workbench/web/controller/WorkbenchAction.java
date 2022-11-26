package com.powernode.web.workbench.web.controller;

import com.powernode.web.workbench.domain.Activity;
import com.powernode.web.workbench.domain.ActivityRemark;
import com.powernode.web.domain.AnonymousStructure;
import com.powernode.web.settings.domain.User;
import com.powernode.web.workbench.service.ActivityRemarkService;
import com.powernode.web.workbench.service.ActivityService;
import com.powernode.web.settings.service.UserService;
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

    @RequestMapping("/contacts/detail")
    public String contactsDetail() {
        return "workbench/contacts/detail";
    }

    @RequestMapping("/contacts/index")
    public String contactsIndex() {
        return "workbench/contacts/index";
    }

    @RequestMapping("/customer/detail")
    public String customerDetail() {
        return "workbench/customer/detail";
    }

    @RequestMapping("/customer/index")
    public String customerIndex() {
        return "workbench/customer/index";
    }

    @RequestMapping("/transaction/index")
    public String transactionIndex() {
        return "workbench/transaction/index";
    }

    @RequestMapping("/transaction/detail")
    public String transactionDetail() {
        return "workbench/transaction/detail";
    }

    @RequestMapping("/transaction/edit")
    public String transactionEdit() {
        return "workbench/transaction/edit";
    }

    @RequestMapping("/transaction/save")
    public String transactionSave() {
        return "workbench/transaction/save";
    }

    @RequestMapping(value = "/index")
    public String workbenchIndex() {
        return "workbench/index";
    }

    @RequestMapping("/main/index")
    public String mainIndex() {
        return "workbench/main/index";
    }

    @RequestMapping("/activity/index")
    public String activityIndex() {
        return "workbench/activity/index";
    }

    @RequestMapping("/activity/detail")
    public String activityDetail(Map<String, String> param, String id) {
        param.putAll(activityService.showActivityWithAllDetailsById(id));
        return "workbench/activity/detail";
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
            public boolean getSuccess() { return activityService.updateActivity(activity); }
        };
    }

    @ResponseBody
    @RequestMapping("/activity/showRemarkListByAid")
    public List<ActivityRemark> activityShowRemarkListByAid(String activityId) {
        return activityRemarkService.getActivityRemarksByAid(activityId);
    }

    @ResponseBody
    @RequestMapping("/activity/deleteRemarkById")
    public AnonymousStructure activityDeleteRemarkById(String activityRemarkId) {
        return new AnonymousStructure() {
            public boolean getSuccess() { return activityRemarkService.deleteRemarkById(activityRemarkId); }
        };
    }

    @ResponseBody
    @RequestMapping(value = "/activity/saveRemark", method = RequestMethod.POST)
    public AnonymousStructure activitySaveRemark(ActivityRemark ar, HttpSession session) {
        ar.setCreateTime(DateTimeUtil.generateNowTime());
        ar.setCreateBy(((User) session.getAttribute("user")).getName());
        ar.setId(UUIDUtil.generateUUID());
        ar.setEditFlag("0");
        return new AnonymousStructure() {
            public boolean getSuccess() {
                return activityRemarkService.addRemark(ar);
            }
            public ActivityRemark getAr() {
                return ar;
            }
        };
    }

    @ResponseBody
    @RequestMapping(value = "/activity/updateRemark", method = RequestMethod.POST)
    public AnonymousStructure activityUpdateRemark(ActivityRemark remark, HttpSession session) {
        remark.setEditFlag("1");
        remark.setEditBy(((User) session.getAttribute("user")).getName());
        remark.setEditTime(DateTimeUtil.generateNowTime());
        return new AnonymousStructure() {
            public boolean getSuccess() { return activityRemarkService.updateRemark(remark); }
            public ActivityRemark getAr() { return remark; }
        };
    }
}
