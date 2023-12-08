package com.vti.backend.service;

import com.vti.backend.repository.UserRepository;
import com.vti.entity.User;

import java.util.List;

public class UserService implements IUserService{
    UserRepository userRepository = new UserRepository();
    @Override
    public List<User> userListInProject(int projectId) {
        return userRepository.userListInProject(projectId);
    }

    @Override
    public List<User> getManager() {
        return userRepository.getManager();
    }

    @Override
    public User login(String email, String password) {
        return userRepository.login(email, password);
    }


    @Override
    public User getUserById(int id){
      return userRepository.getUserById(id);
    }

    @Override
    public void deleteById(int id) {
      userRepository.deleteById(id);
    }
}
