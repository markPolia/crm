package com.powernode.web.service.impl;

import com.powernode.web.service.ActivityService;
import jakarta.annotation.Resource;

public class ActivityServiceImpl implements ActivityService {
    @Resource(type = ActivityService.class)
    private ActivityService service;
}
