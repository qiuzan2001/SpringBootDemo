package com.demo.springboot_demo.pojo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public class UserDto {

    private Integer userId;



    // 使用@NotBlank注解来验证userName字段，确保其不为空且去除首尾空格后不为空
    @NotBlank(message = "Username Cannot Be Empty")
    private String userName;

    // 使用@NotBlank注解来验证password字段，确保其不为空
    // 使用@Length注解来限制密码长度，要求密码长度在8到20个字符之间
    @NotBlank(message = "Password Cannot Be Empty")
    @Length(min = 8, max = 20, message = "Password must be between 8 and 20 characters")
    private String password;

    // 使用@Email注解来验证email字段，确保其格式符合电子邮件地址格式
    @Email(message = "Email Format Incorrect")
    private String email;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
