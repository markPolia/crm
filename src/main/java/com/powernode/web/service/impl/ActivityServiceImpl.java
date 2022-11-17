package com.powernode.web.service.impl;

import com.powernode.web.domain.Activity;
import com.powernode.web.mapper.ActivityMapper;
import com.powernode.web.service.ActivityService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ActivityServiceImpl implements ActivityService {
    @Resource(type = ActivityMapper.class)
    private ActivityMapper mapper;

    @Override
    public boolean saveActivity(Activity activity) {
        return mapper.updateActivity(activity) == 1;
    }
}
