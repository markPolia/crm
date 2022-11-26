package com.powernode.web.settings.web.controller;

import com.powernode.web.settings.service.ClueService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/workbench/clue", method = {RequestMethod.POST, RequestMethod.GET})
public class ClueAction {
    @Resource(type = ClueService.class)
    private ClueService clueService;

    @RequestMapping("/convert")
    public String clueConvert() {
        return "/workbench/clue/convert";
    }

    @RequestMapping("/detail")
    public String clueDetail() {
        return "workbench/clue/detail";
    }

    @RequestMapping("/index")
    public String clueIndex() {
        return "workbench/clue/index";
    }


}
