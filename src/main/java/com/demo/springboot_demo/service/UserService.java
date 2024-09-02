package com.demo.springboot_demo.service;

import com.demo.springboot_demo.pojo.User;
import com.demo.springboot_demo.pojo.dto.UserDto;
import com.demo.springboot_demo.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // 标注此类为Spring的服务类，将其注册为Spring容器中的一个bean
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository; // 自动注入UserRepository，处理数据访问层操作

    @Override
    public User add(UserDto user) {
        // 创建User实体对象
        User userPojo = new User();

        // 使用BeanUtils.copyProperties方法将UserDto中的属性复制到User实体中
        BeanUtils.copyProperties(user, userPojo);

        // 调用数据访问层的save方法，将User实体保存到数据库中
        return userRepository.save(userPojo);
    }

    @Override
    public User getUser(Integer userId) {
        return userRepository.findById(userId).orElseThrow(()-> {
            throw new IllegalArgumentException("User not found");
        });
    }

    @Override
    public User updateUser(UserDto user){
        User userPojo = new User();
        BeanUtils.copyProperties(user, userPojo);
        return userRepository.save(userPojo);

    }

    @Override
    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }
}
