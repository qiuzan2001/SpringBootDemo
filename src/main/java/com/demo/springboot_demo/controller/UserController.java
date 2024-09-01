package com.demo.springboot_demo.controller;

import com.demo.springboot_demo.pojo.ResponseMessage;
import com.demo.springboot_demo.pojo.User;
import com.demo.springboot_demo.pojo.dto.UserDto;
import com.demo.springboot_demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController //接口方法返回对象 转换为json文本，客户端可以更好的处理
@RequestMapping("/user") // localhost:8080/user/**
public class UserController {
    @Autowired
    IUserService userService;

    //REST (而在HTTP协议中，有不同的发送请求的方式，分别是GET、POST、PUT、 DELETE等，
    //      我们如果能让不同的请求方式表示不同的请求类型就可以简化我们的查询，改成名词)

    //Create增
    @PostMapping    //URL: localhost:8080/user  method: POST
    public ResponseMessage<User> add(@Validated @RequestBody UserDto user) {
        User userNew = userService.add(user);
        return ResponseMessage.success(userNew);
        
    }


    //Read删
    //@GetMapping


    //Update改
    //@PutMapping

    //Delete查
    //@DeleteMapping


}
