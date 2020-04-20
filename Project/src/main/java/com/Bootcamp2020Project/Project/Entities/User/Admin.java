package com.Bootcamp2020Project.Project.Entities.User;

import com.Bootcamp2020Project.Project.Entities.User.Users;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "UsersId")
public class Admin extends Users {
    public Admin() { this.addRole(new Role(1l,"ROLE_ADMIN"));}

    public Admin(String email, String firstName, String middleName, String lastName) {
        super(email, firstName, middleName, lastName);
        this.addRole(new Role(1l,"ROLE_ADMIN"));
    }

    @Override
    public String toString() {
        return "Admin{}";
    }
}

