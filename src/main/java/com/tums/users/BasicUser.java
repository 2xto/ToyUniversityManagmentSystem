package com.tums.users;

import java.time.LocalDate;

public abstract class BasicUser implements User {
    private String name, lastName, email;
    private LocalDate birthdate;
    private int id;

    protected BasicUser(int id, String name, String lastName, String email, LocalDate birthdate){
        this.id=id;
        this.name=name;
        this.lastName=lastName;
        this.email=email;
        this.birthdate=birthdate;
    }
}
