package com.mysql_api.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mysql_api.dao.UserDAO;
import com.mysql_api.dao.UserDAOImpel;
import com.mysql_api.dto.UserDTO;
import com.mysql_api.entity.User;
import com.mysql_api.integration.ApiIntegratrion;

import java.util.ArrayList;
import java.util.List;

import static com.mysql_api.utility.UserUtility.isNullOrEmpty;

public class UserServicesImpel implements UserServices {

    @Override
    public List<User> getUsersFromAPI() {

        List<User> users = new ArrayList<>();
        String jsonFile = ApiIntegratrion.getResponse();

        JsonElement jsonElement = JsonParser.parseString(jsonFile);

        if (jsonElement.isJsonArray()) {
            JsonArray jsonArray = jsonElement.getAsJsonArray();

            JsonObject jsonObj = null;
            for (JsonElement arr : jsonArray) {
                jsonObj = arr.getAsJsonObject();

                if (!isNullOrEmpty(jsonObj)) {
                    String id = jsonObj.get("id") != null ? jsonObj.get("id").getAsString() : "";
                    String name = jsonObj.get("name") != null ? jsonObj.get("name").getAsString() : "";
                    String username = jsonObj.get("username") != null ? jsonObj.get("username").getAsString() : "";
                    String email = jsonObj.get("email") != null ? jsonObj.get("email").getAsString() : "";
                    String phone = jsonObj.get("phone") != null ? jsonObj.get("phone").getAsString() : "";

                    JsonObject addressInfo = jsonObj.get("address").getAsJsonObject();
                    if (!isNullOrEmpty(addressInfo)) {
                        String street = addressInfo.get("street") != null ? addressInfo.get("street").getAsString() : "";
                        String suite = addressInfo.get("suite") != null ? addressInfo.get("suite").getAsString() : "";
                        String city = addressInfo.get("city") != null ? addressInfo.get("city").getAsString() : "";

                        String address = street + ", " + suite + ", " + city;

                        if (!isNullOrEmpty(id) && !isNullOrEmpty(name) && !isNullOrEmpty(username) && !isNullOrEmpty(email) && !isNullOrEmpty(phone) && !isNullOrEmpty(address)) {
                            User user = new User();
                            user.setId(id);
                            user.setName(name);
                            user.setUsername(username);
                            user.setEmail(email);
                            user.setPhone(phone);
                            user.setAddress(address);

                            users.add(user);
                        }
                    }
                }
            }
        }
        return users;
    }

    @Override
    public List<User> getUsers() {
        UserDAO userDAO = new UserDAOImpel();
        List<User> users = userDAO.getUsers();
        return users;
    }

    @Override
    public User getUserByID(String id) {
        UserDAO userDAO = new UserDAOImpel();
        User user = userDAO.getUserByID(id);
        return user;
    }

    @Override
    public void addUser(User user) {
        UserDAO userDAO = new UserDAOImpel();
        userDAO.addUser(user);
    }

    @Override
    public void updateUser(UserDTO userDTO, String id) {

        UserDAO userDAO = new UserDAOImpel();

        User existingUser = getUserByID(id);
        existingUser.setName(userDTO.getName());
        existingUser.setUsername(userDTO.getUsername());
        existingUser.setEmail(userDTO.getEmail());
        existingUser.setAddress(userDTO.getAddress());

        userDAO.updateUser(existingUser);
    }

    @Override
    public void removeuser(String id) {
        UserDAO userDAO = new UserDAOImpel();
        userDAO.removeuser(id);
    }
}
