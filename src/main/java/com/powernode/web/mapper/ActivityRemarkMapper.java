package com.powernode.web.mapper;

import com.powernode.web.domain.ActivityRemark;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ActivityRemarkMapper {
    long selectCountByActivityIds(@Param("aids") List<String> aids);

    long deleteByActivityIds(@Param("aids") List<String> aids);

    List<ActivityRemark> selectActivityRemarksByAid(@Param("activityId") String activityId);

    long deleteByRemarkId(String activityRemarkId);
}