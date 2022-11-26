package com.powernode.web.settings.mapper;

import com.powernode.web.settings.domain.CustomerRemark;
import java.util.List;

public interface CustomerRemarkMapper {
    int deleteByPrimaryKey(String id);

    int insert(CustomerRemark row);

    CustomerRemark selectByPrimaryKey(String id);

    List<CustomerRemark> selectAll();

    int updateByPrimaryKey(CustomerRemark row);
}