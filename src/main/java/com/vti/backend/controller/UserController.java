package com.vti.backend.controller;

import com.vti.backend.service.UserService;
import com.vti.entity.User;

import java.util.List;

public class UserController {
    UserService userService = new UserService();
    public List<User> userListInProject(int projectId) {
        return userService.userListInProject(projectId);
    }
    public List<User> getManager() {
        return userService.getManager();
    }
    public User login(String email, String password) {
        return userService.login(email, password);
    }
    public User getUserById(int id){
      return userService.getUserById(id);
    }

    public void deleteById(int id){
      userService.deleteById(id);
    }
}
