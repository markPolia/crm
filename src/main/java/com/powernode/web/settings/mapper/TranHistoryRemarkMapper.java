package com.powernode.web.settings.mapper;

import com.powernode.web.settings.domain.TranHistoryRemark;
import java.util.List;

public interface TranHistoryRemarkMapper {
    int deleteByPrimaryKey(String id);

    int insert(TranHistoryRemark row);

    TranHistoryRemark selectByPrimaryKey(String id);

    List<TranHistoryRemark> selectAll();

    int updateByPrimaryKey(TranHistoryRemark row);
}