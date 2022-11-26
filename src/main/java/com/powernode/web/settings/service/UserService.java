package com.powernode.web.settings.service;

import com.powernode.web.settings.domain.User;
import com.powernode.web.exception.UserException;

import java.util.List;

public interface UserService {
    /**
     *  验证用户是否被允许登陆
     * @param loginAct 登陆用户名
     * @param loginPwd 登陆密码
     * @param remoteAddr 登陆ip
     * @return 登陆是否成功
     * @throws UserException 可能导致的异常
     */
    User login(String loginAct, String loginPwd, String remoteAddr) throws UserException;

    /**
     *  查询所有的用户信息
     * @return 用户列表
     */
    List<User> getAllUsers();

    List<User> getAllUsersNames();
}
