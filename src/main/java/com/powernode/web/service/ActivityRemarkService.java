package com.powernode.web.service;

import com.powernode.web.domain.ActivityRemark;

import java.util.List;

public interface ActivityRemarkService {
    /**
     *  根据活动id，查询出该活动所有的备注
     * @param activityId 活动id
     * @return 活动备注列表
     */
    List<ActivityRemark> getActivityRemarksByAid(String activityId);

    boolean deleteRemarkById(String activityRemarkId);

    boolean addRemark(ActivityRemark ar);

    boolean updateRemark(ActivityRemark remark);
}
