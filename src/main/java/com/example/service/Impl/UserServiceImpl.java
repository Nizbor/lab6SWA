package com.example.service.Impl;

import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(String login, String password, String email) {
        User user = new User(login, password, email);
        return userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public User getById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getByUsername(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public Boolean doLog(String login, String password) {
        return getByUsername(login) != null && getByUsername(login).getPassword().equals(password);
    }

    public Boolean testLoginAndEmail(String login, String email){
        return getByUsername(login) != null || getByEmail(login)!= null;
    }

    @Override
    public String findRoleByLogin(String login) {
        return userRepository.findRoleByLogin(login).getRole();
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.findByEmail(email);
    }


}

