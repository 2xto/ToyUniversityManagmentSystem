package com.tums.users;

public class AdminUser{
    private int id;
    private String name, lastName, email, password;

    protected AdminUser(int id, String name, String lastName, String email, String password) {
        this.id=id;
        this.name=name;
        this.lastName=lastName;
        this.email=email;
        this.password=password;
    }
}
