package com.powernode.web.mapper;

import com.powernode.web.domain.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    User logIn(Map<String, String> params);

    int deleteByPrimaryKey(String id);

    int insert(User row);

    User selectByPrimaryKey(String id);

    List<User> selectAll();

    int updateByPrimaryKey(User row);
}