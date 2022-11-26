package com.powernode.web.settings.mapper;

import com.powernode.web.settings.domain.DicValue;
import java.util.List;

public interface DicValueMapper {
    int deleteByPrimaryKey(String id);

    int insert(DicValue row);

    DicValue selectByPrimaryKey(String id);

    List<DicValue> selectAll();

    int updateByPrimaryKey(DicValue row);
}