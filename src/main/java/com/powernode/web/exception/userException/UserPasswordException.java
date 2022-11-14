package com.powernode.web.exception.userException;

import com.powernode.web.exception.UserException;

/**
 *  用户登陆的账户名或密码错误
 */
public class UserPasswordException extends UserException {
    public UserPasswordException() {
    }

    public UserPasswordException(String message) {
        super(message);
    }
}
