package com.powernode.web.exception.userException;

import com.powernode.web.exception.UserException;

/**
 *  用户登陆ip异常
 */
public class UserLogIpException extends UserException {
    public UserLogIpException() {
    }

    public UserLogIpException(String message) {
        super(message);
    }
}
