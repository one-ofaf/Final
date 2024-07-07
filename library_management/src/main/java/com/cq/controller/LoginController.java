package com.cq.controller;

import com.cq.pojo.Result;
import com.cq.pojo.User;
import com.cq.service.UserService;
import com.cq.until.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody User user ){
        log.info("用户登录: {}", user);
        User e = userService.login(user);

        //登录成功,生成令牌,下发令牌
        if (e != null){
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", e.getUserID());
            claims.put("name", e.getUserName());

            String jwt = JwtUtils.generateJwt(claims); //jwt包含了当前登录的用户
            return Result.success(jwt);
        }

        //登录失败, 返回错误信息
        return Result.error("用户名或密码错误");
    }

}