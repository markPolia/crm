package com.powernode.web.settings.mapper;

import com.powernode.web.settings.domain.ClueRemark;
import java.util.List;

public interface ClueRemarkMapper {
    int deleteByPrimaryKey(String id);

    int insert(ClueRemark row);

    ClueRemark selectByPrimaryKey(String id);

    List<ClueRemark> selectAll();

    int updateByPrimaryKey(ClueRemark row);
}