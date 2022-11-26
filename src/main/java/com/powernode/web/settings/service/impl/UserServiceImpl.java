package com.powernode.web.settings.service.impl;

import com.powernode.web.settings.domain.User;
import com.powernode.web.exception.UserException;
import com.powernode.web.exception.userException.UserExpireException;
import com.powernode.web.exception.userException.UserLockException;
import com.powernode.web.exception.userException.UserLogIpException;
import com.powernode.web.exception.userException.UserPasswordException;
import com.powernode.web.settings.mapper.UserMapper;
import com.powernode.web.settings.service.UserService;
import com.powernode.web.util.DateTimeUtil;
import com.powernode.web.util.MD5Util;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Resource(type = UserMapper.class)
    private UserMapper mapper;

    @Override
    public User login(String loginAct, String loginPwd, String ip) throws UserException {
        HashMap<String, String> userLogInfoMap = new HashMap<>();
        userLogInfoMap.put("loginAct", loginAct);
        userLogInfoMap.put("loginPwd", MD5Util.generateMD5(loginPwd));
        userLogInfoMap.put("ip", ip);
        User user = mapper.logIn(userLogInfoMap);
        if (user == null) {
            throw new UserPasswordException("账号或密码错误");
        } else if (DateTimeUtil.generateNowTime().compareTo(user.getExpireTime()) > 0) {
            // 验证过期时间
            throw new UserExpireException("用户账户已过期");
        } else if ("0".equals(user.getLockState())) {
            // 验证账户状态
            throw new UserLockException("用户账号已锁定");
        } else if (!user.getAllowIps().contains(ip)) {
            // 验证账户登陆ip
            throw new UserLogIpException("用户ip非本地");
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return mapper.selectAllUsers();
    }

    @Override
    public List<User> getAllUsersNames() {
        return mapper.selectAllUsersNames();
    }
}
