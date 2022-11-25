package com.powernode.web.service.impl;

import com.powernode.web.domain.ActivityRemark;
import com.powernode.web.mapper.ActivityRemarkMapper;
import com.powernode.web.service.ActivityRemarkService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ActivityRemarkServiceImpl implements ActivityRemarkService {
    @Resource(type = ActivityRemarkMapper.class)
    private ActivityRemarkMapper activityRemarkMapper;

    @Override
    public List<ActivityRemark> getActivityRemarksByAid(String activityId) {
        return activityRemarkMapper.selectActivityRemarksByAid(activityId);
    }

    @Override
    public boolean deleteRemarkById(String activityRemarkId) {
        return activityRemarkMapper.deleteByRemarkId(activityRemarkId) == 1;
    }
}
