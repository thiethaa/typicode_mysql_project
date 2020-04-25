package com.mysql_api.service;

import com.mysql_api.dto.UserDTO;
import com.mysql_api.entity.User;

import java.util.List;

public interface UserServices {

    List<User> getUsersFromAPI();

    List<User> getUsers();

    User getUserByID(String id);

    void addUser(User user);

    void updateUser(UserDTO userDTO, String id);

    void removeuser(String id);


}
