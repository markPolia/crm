package com.powernode.web.settings.mapper;

import com.powernode.web.settings.domain.Tran;
import java.util.List;

public interface TranMapper {
    int deleteByPrimaryKey(String id);

    int insert(Tran row);

    Tran selectByPrimaryKey(String id);

    List<Tran> selectAll();

    int updateByPrimaryKey(Tran row);
}