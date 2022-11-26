package com.powernode.web.settings.mapper;

import com.powernode.web.settings.domain.Customer;
import java.util.List;

public interface CustomerMapper {
    int deleteByPrimaryKey(String id);

    int insert(Customer row);

    Customer selectByPrimaryKey(String id);

    List<Customer> selectAll();

    int updateByPrimaryKey(Customer row);
}