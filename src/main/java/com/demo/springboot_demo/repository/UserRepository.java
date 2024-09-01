package com.demo.springboot_demo.repository;

import com.demo.springboot_demo.pojo.User;
import com.demo.springboot_demo.pojo.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository //spring的bean
public interface UserRepository extends CrudRepository<User, Integer> {

}
