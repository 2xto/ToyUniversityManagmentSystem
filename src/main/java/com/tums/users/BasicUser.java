package com.tums.users;

import java.time.LocalDate;


public abstract class BasicUser implements User {
    private String name, lastName, email, password;
    private LocalDate birthdate;
    private int id;

    public BasicUser(int id, String name, String lastName, String email, String password, LocalDate birthdate){
        this.id=id;
        this.name=name;
        this.lastName=lastName;
        this.email=email;
        this.password=password;
        this.birthdate=birthdate;
    }
    public BasicUser(){
        this.id=0;
        this.name="";
        this.lastName="";
        this.email="";
        this.password="";
        this.birthdate=null;
    }
}
