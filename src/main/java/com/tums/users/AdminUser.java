package com.tums.users;

import java.time.LocalDate;

public class AdminUser extends BasicUser {
    protected AdminUser(int id, String name, String lastName, String email, LocalDate birthdate) {
        super(id, name, lastName, email, birthdate);
    }
}
