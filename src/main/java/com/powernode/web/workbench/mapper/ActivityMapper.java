package com.powernode.web.workbench.mapper;

import com.powernode.web.workbench.domain.Activity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ActivityMapper {
    int saveActivity(Activity activity);

    List<Activity> selectActivitiesByPage(@Param("pageNo") Integer pageNo, @Param("pageSize") Integer pageSize,
                                          @Param("activity") Activity activity);

    /**
     *  查询总记录条数
     * @return 总记录条数
     */
    Integer selectActivitiesNums(@Param("activity") Activity activity);

    long deleteByIds(@Param("ids") List<String> ids);

    /**
     *  根据id获取活动的所有信息，但不包括活动信息的备注，活动所有者以user表中的真名形式展示
     * @param id activity id
     * @return 活动对象
     */
    Activity selectByAid(@Param("id") String id);

    int updateActivity(Activity activity);

    /**
     *  根据id获取活动的所有信息，包括活动信息的备注
     *  <pre>
     *      一些较容易混淆的字段
     *      aid     -活动id
     *      uid     -用户id
     *      uname   -用户姓名
     *      name    -活动名称</pre>
     * @param id activity id
     * @return 活动对象
     */
    Map<String, String> selectAllInfoByAid(String id);
}