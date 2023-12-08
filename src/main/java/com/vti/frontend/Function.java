package com.vti.frontend;

import com.vti.backend.controller.UserController;
import com.vti.entity.Role;
import com.vti.entity.User;
import com.vti.utils.JdbcUtils;
import com.vti.utils.Scannerutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Function {
    UserController userController = new UserController();
    public void userListInProject(){
        System.out.println("Nhập vào projectId cần tìm: ");
        int projectId = Scannerutils.inputNumber();
        List<User> userList = userController.userListInProject(projectId);
        System.out.println("DANH SÁCH USER CỦA PROJECT " + projectId);
        String leftAlignFormat = "| %-3s | %-20s | %-20s | %-10s |%n";
        System.out.format("+-----+----------------------+----------------------+------------+%n");
        System.out.format("|  id |       fullname       |         email        |     role   |%n");
        System.out.format("+-----+----------------------+----------------------+------------+%n");
        for (User user : userList){
            System.out.format(leftAlignFormat,user.getId(),user.getFullName(),user.getEmail(),user.getRole());
        }
        System.out.format("+-----+----------------------+----------------------+------------+%n");
    }
    public void getManager() {
        List<User> userList = userController.getManager();
        System.out.println("DANH SÁCH MANAGER ");
        String leftAlignFormat = "| %-3s | %-20s | %-20s | %-10s |%n";
        System.out.format("+-----+----------------------+----------------------+------------+%n");
        System.out.format("|  id |       fullname       |         email        |  projectId |%n");
        System.out.format("+-----+----------------------+----------------------+------------+%n");
        for (User user : userList) {
            System.out.format(leftAlignFormat, user.getId(), user.getFullName(), user.getEmail(), user.getProjectId());
        }
        System.out.format("+-----+----------------------+----------------------+------------+%n");
    }
    public void login() {
        System.out.println("Mời bạn nhập vào email: ");
        String email = Scannerutils.emailString();

        System.out.println("Mời bạn nhập vào password: ");
        String password = Scannerutils.inputPassword();

        User user = userController.login(email, password);

        while (user == null) {
            System.err.println("User hoặc mật khẩu không chính xác, mời bạn nhập lại!");
            System.out.println("Mời bạn nhập vào email: ");
            email = Scannerutils.emailString();
            System.out.println("Mời bạn nhập vào password: ");
            password = Scannerutils.inputPassword();

            user = userController.login(email, password);
        }
        System.out.println("Welcome " + user.getFullName());
    }

    public void getUserById() {
      System.out.println("NHập vào id");
      int id = Scannerutils.inputNumber();
      User user = userController.getUserById(id);
      String leftAlignFormat = "| %-3s | %-20s | %-20s | %-10s |%n";
      System.out.format("+-----+----------------------+----------------------+------------+%n");
      System.out.format("|  id |       fullname       |         email        |  projectId |%n");
      System.out.format("+-----+----------------------+----------------------+------------+%n");
      System.out.format(leftAlignFormat, user.getId(), user.getFullName(), user.getEmail(), user.getProjectId());
      System.out.format("+-----+----------------------+----------------------+------------+%n");
    }

    public void deleteById() {
      System.out.println("NHập vào id");
      int id = Scannerutils.inputNumber();
      userController.deleteById(id);
      getManager();
    }
}
