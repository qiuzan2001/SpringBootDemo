package com.demo.springboot_demo.service;

import com.demo.springboot_demo.pojo.User;
import com.demo.springboot_demo.pojo.dto.UserDto;
import com.demo.springboot_demo.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //Sprint的bean
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User add(UserDto user) {

        User userPojo = new User();
        BeanUtils.copyProperties(user,userPojo);
        //调用数据访问类
        return userRepository.save(userPojo);
    }
}
