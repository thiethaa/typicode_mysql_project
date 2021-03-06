package com.mysql_api.entity;

public class User {
    private String id;
    private String name;
    private String username;
    private String email;
    private String phone;
    private String address;

    public User() {}

    public User(String id, String name, String username, String email, String phone, String address) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User Info\t\t:" +
                "\n\t\tid\t\t\t=\t\t" + id +
                "\n\t\tname\t\t=\t\t" + name +
                "\n\t\tusername\t=\t\t" + username +
                "\n\t\temail\t\t=\t\t" + email +
                "\n\t\tphone\t\t=\t\t" + phone +
                "\n\t\taddress\t\t=\t\t" + address;
    }
}
