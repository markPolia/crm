package com.powernode.web.mapper;

import com.powernode.web.domain.ActivityRemark;
import java.util.List;

public interface ActivityRemarkMapper {
    int deleteByPrimaryKey(String id);

    int insert(ActivityRemark row);

    ActivityRemark selectByPrimaryKey(String id);

    List<ActivityRemark> selectAll();

    int updateByPrimaryKey(ActivityRemark row);
}