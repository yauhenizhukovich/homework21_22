package com.gmail.supersonicleader.mvc.service.constant;

public interface UserValidationMessages {

    String NOT_NULL_USERNAME_MESSAGE = "Username cannot be empty";
    String USERNAME_SIZE_MESSAGE = "Username length should be from 3 to 13";
    String USERNAME_REGEXP_MESSAGE = "Username can contain only letters, digits and underscore";
    String NOT_NULL_PASSWORD_MESSAGE = "Password cannot be empty";
    String PASSWORD_SIZE_MESSAGE = "Password length should be from 4 to 13";
    String PASSWORD_REGEXP_MESSAGE = "Password can contain only letters and digits";

}
