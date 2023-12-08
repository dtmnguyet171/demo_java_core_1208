package com.vti.backend.service;

import com.vti.entity.User;

import java.util.List;

public interface IUserService {
    List<User> userListInProject(int projectId);
    List<User> getManager();
    User login(String email, String password);

    User getUserById(int id);

    void deleteById(int id);
}
