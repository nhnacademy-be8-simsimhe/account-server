package com.simsimbookstore.accountserver.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String userId) {
        super("not found user with id " + userId);
    }
}
