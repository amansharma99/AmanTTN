package com.Bootcamp2020Project.Project.Entities.User;

import com.Bootcamp2020Project.Project.Entities.User.Users;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String authority;
    private boolean isDeleted = false;
    @ManyToMany(mappedBy = "roles")
    private Set<Users> users;

    public Boolean isDeleted() {
        return isDeleted();
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Role() {

    }

    public Role(Long id, String authority) {
        this.id = id;
        this.authority = authority;
    }


    @Override
    public String getAuthority() {
        return null;
    }

    public Set<Users> getUsers() {
        return users;
    }

    public void setUsers(Set<Users> users) {
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void addUser(Users users1) {
        if (users == null)
            users = new HashSet<>();

        users.add(users1);
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", authority='" + authority + '\'' +
                ", isDeleted=" + isDeleted +
                ", users=" + users +
                '}';
    }
}
