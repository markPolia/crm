package com.powernode.web.service.impl;

import com.powernode.web.domain.User;
import com.powernode.web.mapper.ActivityMapper;
import com.powernode.web.service.ActivityService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ActivityServiceImpl implements ActivityService {
    @Resource(type = ActivityMapper.class)
    private ActivityMapper mapper;

}
