package com.gmail.supersonicleader.mvc.service.constant;

public interface UserValidationRules {

    int MIN_USERNAME_SIZE = 3;
    int MAX_USERNAME_SIZE = 13;
    String USERNAME_REGEXP = "^[\\w\\d_]*$";
    int MIN_PASSWORD_SIZE = 4;
    int MAX_PASSWORD_SIZE = 13;
    String PASSWORD_REGEXP = "^[\\w\\d]*$";

}
