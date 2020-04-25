package com.mysql_api.dao;

import com.mysql_api.entity.User;

import java.util.List;

public interface UserDAO {

    List<User> getUsers();

    User getUserByID(String id);

    void addUser(User user);

    void updateUser(User user);

    void removeuser(String id);

}
