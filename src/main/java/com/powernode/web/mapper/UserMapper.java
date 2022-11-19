package com.powernode.web.mapper;

import com.powernode.web.domain.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    User logIn(Map<String, String> params);

    List<User> selectAllUsers();

    List<User> selectAllUsersNames();
}