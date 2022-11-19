package com.powernode.web.mapper;

import com.powernode.web.domain.Activity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ActivityMapper {
    int updateActivity(Activity activity);

    List<Activity> selectActivitiesByPage(@Param("pageNo") Integer pageNo, @Param("pageSize") Integer pageSize,
                                          @Param("activity") Activity activity);

    /**
     *  查询总记录条数
     * @return 总记录条数
     */
    Integer selectActivitiesNums(@Param("activity") Activity activity);
}