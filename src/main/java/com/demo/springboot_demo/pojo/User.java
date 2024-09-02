package com.demo.springboot_demo.pojo;

import jakarta.persistence.*;

// 标注此类为JPA实体，并与数据库表"table_user"映射
@Table(name="table_user")
@Entity
public class User {
    // 标注此字段为主键，使用数据库自增策略
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id") // 将字段"userId"映射为数据库表中的"user_id"列
    private Integer userId;

    // 将字段"userName"映射为数据库表中的"user_name"列
    @Column(name = "user_name")
    private String userName;

    // 将字段"password"映射为数据库表中的"password"列
    @Column(name = "password")
    private String password;

    // 将字段"email"映射为数据库表中的"email"列
    @Column(name="email")
    private String email;

    // 用户ID
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    // 用户名
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    // 用户密码
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    // 用户邮箱
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    // 重写toString方法，便于输出User对象的属性信息
    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
