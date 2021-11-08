package com.tums.users;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class StudentUser extends  BasicUser {
    protected List<StudentUser> studentUserList;
    protected StudentUser(int id, String name, String lastName, String email, LocalDate birthdate) {
        super(id, name, lastName, email, birthdate);
        this.studentUserList=new LinkedList<>();
    }
}
