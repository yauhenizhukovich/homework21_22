package com.gmail.supersonicleader.mvc.service.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.gmail.supersonicleader.mvc.repository.model.RoleEnum;

import static com.gmail.supersonicleader.mvc.service.constant.UserValidationMessages.NOT_NULL_PASSWORD_MESSAGE;
import static com.gmail.supersonicleader.mvc.service.constant.UserValidationMessages.NOT_NULL_USERNAME_MESSAGE;
import static com.gmail.supersonicleader.mvc.service.constant.UserValidationMessages.PASSWORD_REGEXP_MESSAGE;
import static com.gmail.supersonicleader.mvc.service.constant.UserValidationMessages.PASSWORD_SIZE_MESSAGE;
import static com.gmail.supersonicleader.mvc.service.constant.UserValidationMessages.USERNAME_REGEXP_MESSAGE;
import static com.gmail.supersonicleader.mvc.service.constant.UserValidationMessages.USERNAME_SIZE_MESSAGE;
import static com.gmail.supersonicleader.mvc.service.constant.UserValidationRules.MAX_PASSWORD_SIZE;
import static com.gmail.supersonicleader.mvc.service.constant.UserValidationRules.MAX_USERNAME_SIZE;
import static com.gmail.supersonicleader.mvc.service.constant.UserValidationRules.MIN_PASSWORD_SIZE;
import static com.gmail.supersonicleader.mvc.service.constant.UserValidationRules.MIN_USERNAME_SIZE;
import static com.gmail.supersonicleader.mvc.service.constant.UserValidationRules.PASSWORD_REGEXP;
import static com.gmail.supersonicleader.mvc.service.constant.UserValidationRules.USERNAME_REGEXP;

public class UserDTO {

    @NotNull(message = NOT_NULL_USERNAME_MESSAGE)
    @Size(min = MIN_USERNAME_SIZE, max = MAX_USERNAME_SIZE, message = USERNAME_SIZE_MESSAGE)
    @Pattern(regexp = USERNAME_REGEXP, message = USERNAME_REGEXP_MESSAGE)
    private String username;
    @NotNull(message = NOT_NULL_PASSWORD_MESSAGE)
    @Size(min = MIN_PASSWORD_SIZE, max = MAX_PASSWORD_SIZE, message = PASSWORD_SIZE_MESSAGE)
    @Pattern(regexp = PASSWORD_REGEXP, message = PASSWORD_REGEXP_MESSAGE)
    private String password;
    private RoleEnum role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    public RoleEnum getRole() {
        return role;
    }

}
