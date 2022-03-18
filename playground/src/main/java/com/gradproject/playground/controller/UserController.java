package com.gradproject.playground.controller;

import com.gradproject.playground.entity.User;
import com.gradproject.playground.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/updateUser")
    @ResponseBody
    public String updateUser(User user) {
        boolean flag = userService.upUser(user);
        if (flag)
            return "修改成功";
        return "修改失败";
    }

    public String delUser(int id) {
        if (userService.delUser(id))
            return "注销成功";
        return "注销失败";
    }

    public String delUser(String email) {

    }
}
