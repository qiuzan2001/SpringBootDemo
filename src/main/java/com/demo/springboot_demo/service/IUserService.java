package com.demo.springboot_demo.service;

import com.demo.springboot_demo.pojo.User;
import com.demo.springboot_demo.pojo.dto.UserDto;
import org.springframework.stereotype.Service;


public interface IUserService {
    /**
     * 插入用户
     * @param user  参数
     */
    User add(UserDto user);

    /**
     * 查询用户
     * @param userId
     * @return
     */
    User getUser(Integer userId);

    /**
     * 修改用户对象
     * @param userId
     * @return
     */
    User updateUser(UserDto user);

    /**
     * 删除用户对象
     * @param userId
     * @return
     */
    void deleteUser(Integer userId);
}
