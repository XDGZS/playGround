package com.gradproject.playground.mapper;

import com.gradproject.playground.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    public int addUser(User user);

    public User findByEmail(String email);

    public List<User> findAll();

    public int updateUser(User user);

    public int deleteByEmail(String email);

    public User findByEmail$Password(String email,String password);

    public int delUserById(int id);
}
