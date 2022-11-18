package com.powernode.web.service.impl;

import com.powernode.web.domain.Activity;
import com.powernode.web.mapper.ActivityMapper;
import com.powernode.web.service.ActivityService;
import com.powernode.web.vo.PageInfo;
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

    @Override
    public PageInfo<Activity> showActivitiesInPageInfo(Integer pageNo, Integer pageSize, Activity activity) {
        PageInfo<Activity> activityPageInfo = new PageInfo<>();
        // 总记录条数
        final int total = mapper.selectActivitiesNums();
        // 页数
        final int pageNums = total % pageSize == 0 ? total / pageSize : (total / pageSize) + 1;
        activityPageInfo.setDataList(mapper.selectActivitiesByPage(pageNo, pageSize, activity));
        activityPageInfo.setTotal(total);
        activityPageInfo.setPageSize(pageNums);
        return activityPageInfo;
    }
}
