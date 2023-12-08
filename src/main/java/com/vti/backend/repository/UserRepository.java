package com.vti.backend.repository;

import com.vti.entity.Role;
import com.vti.entity.User;
import com.vti.utils.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    public List<User> userListInProject(int projectId){
        List<User> userList = new ArrayList<>();
        String sql = "SELECT * FROM final_exam.user WHERE project_id = ?";
        Connection connection = JdbcUtils.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, projectId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setFullName(resultSet.getString("full_name"));
                user.setEmail(resultSet.getString("email"));
                user.setRole(Role.valueOf(resultSet.getString("role")));
                userList.add(user);
            }
            return userList;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            JdbcUtils.closeConnection();
        }
        return null;
    }
    public List<User> getManager(){
        List<User> userList = new ArrayList<>();
        String sql = "SELECT * FROM final_exam.user U WHERE role = 'MANAGER'";
        Connection connection = JdbcUtils.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setFullName(resultSet.getString("full_name"));
                user.setEmail(resultSet.getString("email"));
                user.setProjectId(resultSet.getInt("project_id"));
                userList.add(user);
            }
            return userList;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            JdbcUtils.closeConnection();
        }
        return null;
    }
    public User login(String email, String password){
        String sql = "SELECT * FROM final_exam.user WHERE email = ? AND password = ?";
        Connection connection = JdbcUtils.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setFullName(resultSet.getString("full_name"));
                user.setEmail(resultSet.getString("email"));
                user.setRole(Role.valueOf(resultSet.getString("role")));
                return user;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            JdbcUtils.closeConnection();
        }
        return null;
    }

    public User getUserById(int id){
      Connection connection = JdbcUtils.getConnection();
      String sql = "select * from user where id = ?";
      try {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
          User user = new User();
          user.setId(resultSet.getInt("id"));
          user.setFullName(resultSet.getString("full_name"));
          user.setEmail(resultSet.getString("email"));
          user.setRole(Role.valueOf(resultSet.getString("role")));
          return user;
        }
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      } finally {
        JdbcUtils.closeConnection();
      }
      return null;
    }

    public void deleteById(int id) {
      Connection connection = JdbcUtils.getConnection();
      String sql = "DELETE FROM user where id = ?";
      try {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        int rs = preparedStatement.executeUpdate();
        if (rs > 0) {
          System.out.println("Xóa bản ghi thành công");
        } else {
          System.out.println("Không thể xóa bản ghi");
        }
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      } finally {
        JdbcUtils.closeConnection();
      }
    }
}
