package com.powernode.web.service;

import com.powernode.web.domain.User;
import com.powernode.web.exception.UserException;

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
}
