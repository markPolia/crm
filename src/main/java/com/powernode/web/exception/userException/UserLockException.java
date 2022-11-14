package com.powernode.web.exception.userException;

import com.powernode.web.exception.UserException;

/**
 *  用户账户锁定异常
 */
public class UserLockException extends UserException {
    public UserLockException() {
    }

    public UserLockException(String message) {
        super(message);
    }
}
