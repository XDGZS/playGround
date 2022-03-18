package com.gradproject.playground.service;

import com.gradproject.playground.entity.User;
import com.gradproject.playground.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    private Map<String, User> userMap;

    public UserService() {
        userMap = new HashMap<>();

    }

    private void find() {
        userMap.clear();
        List<User> users = userMapper.findAll();
        for (User user : users) {
            userMap.put(user.getEmail(), user);
        }
    }

    public boolean login(String email, String password) {
        find();
        if (userMap.containsKey(email)) {
            User user = userMapper.findByEmail$Password(email, password);
            if (user != null)
                return true;
        }
        return false;
    }

    public boolean register(User user) {
        find();
        if (userMap.containsKey(user.getEmail()))
            return false;
        int code = userMapper.addUser(user);
        return code > 0 ? true : false;
    }

    public User findByEmail(String email) {
        return userMapper.findByEmail(email);
    }

    public boolean upUser(User user) {
        int flag = userMapper.updateUser(user);
        return flag > 0 ? true : false;
    }

    public boolean delUser(int id) {
        int flag = userMapper.delUserById(id);
        return flag > 0 ? true : false;
    }
}
