package com.powernode.web.mapper;

import com.powernode.web.domain.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User row);

    User selectByPrimaryKey(String id);

    List<User> selectAll();

    int updateByPrimaryKey(User row);
}