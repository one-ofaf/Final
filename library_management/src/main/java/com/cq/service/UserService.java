package com.cq.service;

import com.cq.pojo.User;

import java.util.List;

public interface UserService {

     User login(User user);

    ;

    void save(User user);

    void delete(List<Integer> ids);

    List<User> find();

    void update(User user);

    User registService(User newUser);
}
