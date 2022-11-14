package com.powernode.web.exception.userException;

import com.powernode.web.exception.UserException;

/**
 *  账户已过期
 */
public class UserExpireException extends UserException {
    public UserExpireException() {
    }

    public UserExpireException(String message) {
        super(message);
    }
}
