package com.powernode.web.settings.mapper;

import com.powernode.web.settings.domain.TranHistory;
import java.util.List;

public interface TranHistoryMapper {
    int deleteByPrimaryKey(String id);

    int insert(TranHistory row);

    TranHistory selectByPrimaryKey(String id);

    List<TranHistory> selectAll();

    int updateByPrimaryKey(TranHistory row);
}