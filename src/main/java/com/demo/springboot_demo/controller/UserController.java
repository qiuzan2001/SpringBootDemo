package com.demo.springboot_demo.controller;

import com.demo.springboot_demo.pojo.ResponseMessage;
import com.demo.springboot_demo.pojo.User;
import com.demo.springboot_demo.pojo.dto.UserDto;
import com.demo.springboot_demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController // 标注此类为RESTful控制器，返回的对象会自动转换为JSON格式，方便客户端处理
@RequestMapping("/user") // 配置请求路径的前缀，例如所有的请求都会以localhost:8080/user开头
public class UserController {

    @Autowired // 自动注入依赖关系。Spring会自动寻找并注入适合的bean到这个变量中。
    IUserService userService; // 注入用户服务接口，用于处理用户相关的业务逻辑

    // REST风格的API设计遵循HTTP动词（如GET、POST、PUT、DELETE等）来定义操作类型。
    // 例如，GET表示获取资源，POST表示创建资源，PUT表示更新资源，DELETE表示删除资源。
    // 这种方式可以使接口设计更简洁、更符合语义。

    // Create（增）
    @PostMapping // 处理POST请求，URL为localhost:8080/user
    public ResponseMessage<User> add(@Validated @RequestBody UserDto user) {
        // 使用@Validated注解来校验请求体中的UserDto对象
        // @RequestBody表示从请求体中获取JSON数据并转换为UserDto对象

        User userNew = userService.add(user); // 调用服务层的add方法，将UserDto转换并保存为User实体
        return ResponseMessage.success(userNew); // 返回封装后的成功响应，包含新创建的User对象
    }

    // Read（查）
    @GetMapping("/{userId}") // 处理GET请求，通常用于获取资源    method:GET
    public ResponseMessage<User> read(@PathVariable Integer userId) {
        User userNew = userService.getUser(userId);
        return ResponseMessage.success(userNew);
    }

    // Update（改）
    @PutMapping // 处理PUT请求，通常用于更新资源
    public ResponseMessage<User> update(@Validated @RequestBody UserDto user) {
        User userNew = userService.updateUser(user);
        return ResponseMessage.success(userNew);
    }




    // Delete（删）
    @DeleteMapping("/{userId}") // 处理DELETE请求，通常用于删除资源
    public ResponseMessage<User> delete(@PathVariable Integer userId) {
        userService.deleteUser(userId);
        return ResponseMessage.success();
    }

}
