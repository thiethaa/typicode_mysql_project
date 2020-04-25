package com.mysql_api.app;

import com.mysql_api.dto.UserDTO;
import com.mysql_api.entity.User;
import com.mysql_api.service.UserConverter;
import com.mysql_api.service.UserServices;
import com.mysql_api.service.UserServicesImpel;

import java.util.List;

public class App {
    public static void main(String[] args) {

        UserServices userServices = new UserServicesImpel();
/* return List from JsonAPI
        List<User> users = userServices.getUsersFromAPI();
       adding Users to Database
        for(User u : users){
            userServices.addUser(u);
        }

retirn List from DataBase
       List<User> usersFromDb = userServices.getUsers();
        for(User u : usersFromDb){
            /*delete users from Database
                userServices.removeuser();
        }
         */
/*// create data transfer object (DTO)
        UserDTO userDTO = new UserDTO();
        userDTO.setName("fatur abdul");
        userDTO.setUsername("eagle");
        userDTO.setEmail("faiz@gmail.li.com");
        userDTO.setPhone("62-909-888-99");
        userDTO.setAddress("palu sulteng");
// convert UserDTO into User to perform Database Updating
        User userConvert = UserConverter.convertTo(userDTO,"12");
        userServices.addUser(userConvert);
        userServices.updateUser(userDTO,"12");*/
    }
}
