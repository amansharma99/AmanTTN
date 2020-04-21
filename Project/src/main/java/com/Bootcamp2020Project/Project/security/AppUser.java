package com.Bootcamp2020Project.Project.security;

import com.Bootcamp2020Project.Project.Entities.User.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public class AppUser implements UserDetails {

    private String username;
    private String password;
    Set<Role> roles;
    private boolean isActive;
    public AppUser(String username, String password, Set<Role> roles) {
        this.username = username;
        this.password = password;
        this.roles=roles;
    }

    public AppUser(User user) {

    }
    public AppUser(String username, String password, Set<Role> grantAuthorities,boolean is_active) {
        this.username = username;
        this.password = password;
        this.roles = grantAuthorities;
        this.isActive=is_active;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }
}