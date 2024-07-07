package com.cq.controller;

import com.cq.pojo.Result;
import com.cq.pojo.User;
import com.cq.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/user")
public class RegisterController {
    @Autowired
    private UserService userService;

    //注册用户
    @PostMapping("/register")
    public Result registController(@RequestBody User newUser){
        User user = userService.registService(newUser);
        if(user!=null){
            return Result.success("注册成功！");
        }else{
            return Result.error("用户名已存在！");
        }
    }

}
