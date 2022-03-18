package com.gradproject.playground.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/*
 * 登录表单
 * 2022/3/10
 * */
@Data
public class LoginForm {
    @NotBlank(message = "邮件不能为空")
    @Email(message = "邮件格式不对")
    private String email;

    @NotBlank(message = "密码不能为空")
    @Length(max = 16, min = 8, message = "密码长度为8-16位")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "data set names can only be letters and Numbers")
    private String password;
}
