package com.powernode.web.settings.mapper;

import com.powernode.web.settings.domain.ClueActivityRelation;
import java.util.List;

public interface ClueActivityRelationMapper {
    int deleteByPrimaryKey(String id);

    int insert(ClueActivityRelation row);

    ClueActivityRelation selectByPrimaryKey(String id);

    List<ClueActivityRelation> selectAll();

    int updateByPrimaryKey(ClueActivityRelation row);
}