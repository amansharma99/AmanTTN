package com.Bootcamp2020Project.Project.Entities.User;

import com.Bootcamp2020Project.Project.Entities.User.Users;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "UsersId")
public class Admin extends Users {
    public Admin() {

    }

    public Admin(String email, String firstName, String middleName, String lastName) {
        super(email, firstName, middleName, lastName);
    }
}

