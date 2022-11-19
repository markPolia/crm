package com.powernode.web.service;

import com.powernode.web.domain.Activity;
import com.powernode.web.vo.PageInfo;

import java.util.List;
import java.util.Map;

public interface ActivityService {
    /**
     *  添加市场活动
     * @param activity 市场活动
     * @return 添加是否成功
     */
    boolean saveActivity(Activity activity);

    /**
     * 检索市场活动列表
     *
     * @param pageNo   页码
     * @param pageSize 页面显示记录条数
     * @return 市场活动列表
     */
    PageInfo<Activity> showActivitiesInPageInfo(Integer pageNo, Integer pageSize, Activity activity);

    boolean deleteActivity(List<String> ids);

    Map<String, Object> showActivityWithDetailById(String id);

    boolean updateActivity(Activity activity);
}
