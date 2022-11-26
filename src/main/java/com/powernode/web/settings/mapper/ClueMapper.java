package com.powernode.web.settings.mapper;

import com.powernode.web.settings.domain.Clue;
import java.util.List;

public interface ClueMapper {
    int deleteByPrimaryKey(String id);

    int insert(Clue row);

    Clue selectByPrimaryKey(String id);

    List<Clue> selectAll();

    int updateByPrimaryKey(Clue row);
}