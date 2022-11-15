package com.powernode.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/workbench")
public class WorkbenchAction {
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
}
