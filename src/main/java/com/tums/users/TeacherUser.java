package com.tums.users;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class TeacherUser extends BasicUser{
    protected List<TeacherUser> teacherUserList;
    protected TeacherUser(int id, String name, String lastName, String email, String password, LocalDate birthdate) {
        super(id, name, lastName, email, password, birthdate);
        this.teacherUserList=new LinkedList<>();
    }
}
