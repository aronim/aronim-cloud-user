package com.aronim.cloud.user;

/**
 * User: Kevin W. Sewell
 * Date: 2015-05-29
 * Time: 14h42
 */
public class UserWithEmailAddressAlreadyRegisteredException extends RuntimeException
{
    public UserWithEmailAddressAlreadyRegisteredException()
    {
        super("User with email address already registered!");
    }
}
