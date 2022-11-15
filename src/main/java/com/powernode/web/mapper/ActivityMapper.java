package com.powernode.web.mapper;

import com.powernode.web.domain.Activity;
import java.util.List;

public interface ActivityMapper {
    int deleteByPrimaryKey(String id);

    int insert(Activity row);

    Activity selectByPrimaryKey(String id);

    List<Activity> selectAll();

    int updateByPrimaryKey(Activity row);
}