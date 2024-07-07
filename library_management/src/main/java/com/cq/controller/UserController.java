package com.cq.controller;


import com.cq.pojo.Book;
import com.cq.pojo.Result;
import com.cq.pojo.User;
import com.cq.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    //添加用户
    @PostMapping
    public Result save(@RequestBody User user){
        log.info("新增用户, book: {}",user );
        userService.save(user);
        return Result.success();
    }

    //批量删除用户
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("批量删除操作, ids:{}",ids);
        userService.delete(ids);
        return Result.success();
    }
    //查询用户
    @GetMapping
    public Result find(){
       List<User> list = userService.find();
        return  Result.success(list);
    }
    @PutMapping
    public Result update(@RequestBody User user){
        log.info("修改员工:{}",user);
        userService.update(user);
        return  Result.success();
    }



}
