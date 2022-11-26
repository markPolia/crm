package com.powernode.web.settings.mapper;

import com.powernode.web.settings.domain.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    User logIn(Map<String, String> params);

    List<User> selectAllUsers();

    List<User> selectAllUsersNames();
}