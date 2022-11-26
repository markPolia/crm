package com.powernode.web.settings.mapper;

import com.powernode.web.settings.domain.DicType;
import java.util.List;

public interface DicTypeMapper {
    int deleteByPrimaryKey(String code);

    int insert(DicType row);

    DicType selectByPrimaryKey(String code);

    List<DicType> selectAll();

    int updateByPrimaryKey(DicType row);
}