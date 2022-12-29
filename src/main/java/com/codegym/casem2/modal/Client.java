package com.codegym.casem2.modal;

import java.util.List;

public class Client {
    private  String name;
    private  String email;
    private  String password;
    private  int role;
    private String gender;
    private String address;
    private int phoneNumber;

    public Client() {
    }

    public Client(String name, String email, String password, int role, String gender, String address, int phoneNumber) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }



}
