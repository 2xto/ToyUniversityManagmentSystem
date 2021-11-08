package com.tums.users;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class TeacherUser extends BasicUser{
    protected List<TeacherUser> teacherUserList;
    protected TeacherUser(int id, String name, String lastName, String email, LocalDate birthdate) {
        super(id, name, lastName, email, birthdate);
        this.teacherUserList=new LinkedList<>();
    }
}
