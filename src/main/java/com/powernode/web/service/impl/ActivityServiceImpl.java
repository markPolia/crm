package com.powernode.web.service.impl;

import com.powernode.web.domain.Activity;
import com.powernode.web.mapper.ActivityMapper;
import com.powernode.web.mapper.ActivityRemarkMapper;
import com.powernode.web.mapper.UserMapper;
import com.powernode.web.service.ActivityService;
import com.powernode.web.vo.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ActivityServiceImpl implements ActivityService {
    @Resource(type = ActivityMapper.class)
    private ActivityMapper activityMapper;

    @Resource(type = ActivityRemarkMapper.class)
    private ActivityRemarkMapper activityRemarkMapper;

    @Resource(type = UserMapper.class)
    private UserMapper userMapper;

    @Override
    public boolean saveActivity(Activity activity) {
        return activityMapper.saveActivity(activity) == 1;
    }

    @Override
    public PageInfo<Activity> showActivitiesInPageInfo(Integer pageNo, Integer pageSize, Activity activity) {
        PageInfo<Activity> activityPageInfo = new PageInfo<>();
        activityPageInfo.setDataList(activityMapper.selectActivitiesByPage(pageNo, pageSize, activity));
        // 总记录条数
        final int total = activityMapper.selectActivitiesNums(activity);
        // 页数
        final int pageNums = total % pageSize == 0 ? total / pageSize : (total / pageSize) + 1;
        activityPageInfo.setTotal(total);
        activityPageInfo.setPageSize(pageNums);
        return activityPageInfo;
    }

    @Override
    public boolean deleteActivity(List<String> aids) {
        // 查询删除几条记录
        long activityRemarkItems = activityRemarkMapper.selectCountByActivityIds(aids);
        long activityRemarkDeleteItems = 0;
        // 删除市场活动信息备注表中的数据
        if (activityRemarkItems != 0)
            activityRemarkDeleteItems = activityRemarkMapper.deleteByActivityIds(aids);
        // 删除市场活动中的数据
        if (activityRemarkItems != activityRemarkDeleteItems) {
            throw new RuntimeException("删除市场活动'备注信息'时出错，预期删除条数为：" + activityRemarkItems
                    + "，实际删除条数为：" + activityRemarkDeleteItems);
        }

        long activityDeleteItems = activityMapper.deleteByIds(aids);
        if (activityDeleteItems != aids.size()) {
            throw new RuntimeException("删除市场活动时出错，预期删除条数为：" + aids.size()
                    + "，实际删除条数为：" + activityDeleteItems);
        }
        return true;
    }

    @Override
    public Map<String, Object> showActivityWithDetailById(String id) {
        Map<String, Object> res = new HashMap<>(8);
        res.put("userList", userMapper.selectAllUsersNames());
        res.put("activity", activityMapper.selectByAid(id));
        return res;
    }

    @Override
    public boolean updateActivity(Activity activity) {
        return activityMapper.updateActivity(activity) == 1;
    }

    @Override
    public Map<String, String> showActivityWithAllDetailsById(String id) {
        return activityMapper.selectAllInfoByAid(id);
    }
}
