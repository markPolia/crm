package com.powernode.web.workbench.mapper;

import com.powernode.web.workbench.domain.ActivityRemark;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ActivityRemarkMapper {
    long selectCountByActivityIds(@Param("aids") List<String> aids);

    long deleteByActivityIds(@Param("aids") List<String> aids);

    List<ActivityRemark> selectActivityRemarksByAid(@Param("activityId") String activityId);

    long deleteByRemarkId(String activityRemarkId);

    long insert(ActivityRemark ar);

    long updateRemark(ActivityRemark remark);
}