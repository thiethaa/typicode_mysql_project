package com.mysql_api.service;

import com.mysql_api.dto.UserDTO;
import com.mysql_api.entity.User;

public class UserConverter {

    public static User convertTo(UserDTO userDTO, String id) {
        User user = new User();
        user.setId(id);
        user.setName(userDTO.getName());
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPhone(userDTO.getPhone());
        user.setAddress(userDTO.getAddress());

        return user;
    }

    public static UserDTO convertFrom(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setName(user.getName());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhone(user.getPhone());
        userDTO.setAddress(user.getAddress());

        return userDTO;
    }
}
