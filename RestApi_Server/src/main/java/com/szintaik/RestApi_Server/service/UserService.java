package com.szintaik.RestApi_Server.service;

import com.szintaik.RestApi_Server.model.User;

import java.util.List;

public interface UserService {

    User save(User user);

    User findById(Long id);

    List<User> findAll();

    void delete(User user);

}
