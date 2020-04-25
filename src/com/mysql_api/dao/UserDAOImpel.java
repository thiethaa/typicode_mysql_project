package com.mysql_api.dao;

import com.mysql_api.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpel implements UserDAO {

    private Connection con = null;

    @Override
    public List<User> getUsers() {

        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM tri_username";
        try {
            con = DataBaseConnection.getDbConnection();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getString(1));
                user.setName(resultSet.getString(2));
                user.setUsername(resultSet.getString(3));
                user.setEmail(resultSet.getString(4));
                user.setPhone(resultSet.getString(5));
                user.setAddress(resultSet.getString(6));
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        closeConnection();
        return users;
    }

    @Override
    public User getUserByID(String id) {

        User user = new User();
        String sql = "SELECT * FROM tri_username WHERE id=?";

        try {
            con = DataBaseConnection.getDbConnection();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user.setId(resultSet.getString(1));
                user.setName(resultSet.getString(2));
                user.setUsername(resultSet.getString(3));
                user.setEmail(resultSet.getString(4));
                user.setPhone(resultSet.getString(5));
                user.setAddress(resultSet.getString(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        closeConnection();
        return user;
    }

    @Override
    public void addUser(User user) {
        String sql = "INSERT INTO tri_username(id,name,username,email,phone,address) VALUES(?,?,?,?,?,?)";
        try {
            con = DataBaseConnection.getDbConnection();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, user.getId());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getPhone());
            preparedStatement.setString(6, user.getAddress());

            preparedStatement.execute();
            preparedStatement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        closeConnection();
    }

    @Override
    public void updateUser(User user) {
        String sql = "UPDATE tri_username SET name=?,username=?,email=?,phone=?,address=? WHERE id=?";
        try {
            con = DataBaseConnection.getDbConnection();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPhone());
            preparedStatement.setString(5, user.getAddress());
            preparedStatement.setString(6, user.getId());

            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (Exception e) {
            System.out.println("error updating a User with id: " + user.getId() + " name:" + user.getName());
            e.printStackTrace();
        }

        closeConnection();
    }

    @Override
    public void removeuser(String id) {
        String sql = "DELETE FROM tri_username WHERE id=?";
        try {
            con = DataBaseConnection.getDbConnection();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, id);

            preparedStatement.execute();
            preparedStatement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        closeConnection();
    }

    private void closeConnection() {
        if (con != null) {
           try{
               con.close();
           } catch (Exception ex) {
               System.out.println("Error occured while trying to close the Database connection");
               ex.printStackTrace(System.err);
           }
        }
    }
}
