package com.powernode.web.service.impl;

import com.powernode.web.service.ActivityRemarkService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ActivityRemarkServiceImpl implements ActivityRemarkService {
    @Resource(type = ActivityRemarkService.class)
    private ActivityRemarkService service;
}
