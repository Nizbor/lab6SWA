package com.example.service;

import com.example.model.User;

import java.util.List;

public interface UserService {
    User addUser(String login, String password, String email);
    void delete(User user);
    User getById(Integer id);
    List<User> getAllUsers();
    User updateUser(User user);

    User getByUsername(String login);
    Boolean doLog(String login, String password);
    String findRoleByLogin(String login);
    User getByEmail(String email);
}
