package com.powernode.web.service.impl;

import com.powernode.web.mapper.UserMapper;
import com.powernode.web.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource(type = UserMapper.class)
    private UserMapper mapper;

}
