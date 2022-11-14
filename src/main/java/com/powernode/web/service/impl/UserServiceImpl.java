package com.powernode.web.service.impl;

import com.powernode.web.domain.User;
import com.powernode.web.exception.UserException;
import com.powernode.web.exception.userException.UserExpireException;
import com.powernode.web.exception.userException.UserLockException;
import com.powernode.web.exception.userException.UserLogIpException;
import com.powernode.web.exception.userException.UserPasswordException;
import com.powernode.web.mapper.UserMapper;
import com.powernode.web.service.UserService;
import com.powernode.web.util.MD5Util;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Resource(type = UserMapper.class)
    private UserMapper mapper;

    @Override
    public User login(String loginAct, String loginPwd, String remoteAddr) throws UserException {
        HashMap<String, String> userLogInfoMap = new HashMap<>();
        userLogInfoMap.put("loginAct", MD5Util.generateMD5(loginAct));
        userLogInfoMap.put("loginPwd", MD5Util.generateMD5(loginPwd));
        userLogInfoMap.put("ip", remoteAddr);

        User user = mapper.logIn(userLogInfoMap);

        if (user == null) {
            throw new UserPasswordException("账号或密码错误");
        } else if ("".equals(user.getExpiretime())) {
            throw new UserExpireException("用户账户已过期");
        } else if (user.getAllowips().equals("")) {
            throw new UserLogIpException("用户ip非本地");
        } else if (user.getLockstate().equals("1")) {
            throw new UserLockException("用户账号已锁定");
        }
        return user;
    }
}
