package com.Bootcamp2020Project.Project.security;


import com.Bootcamp2020Project.Project.Entities.User.Role;
import com.Bootcamp2020Project.Project.Entities.User.Users;
import com.Bootcamp2020Project.Project.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class UserDao {
    @Autowired
    UserRepository userRepository;

    public AppUser loadUserByUsername(String username) {
        Users user = userRepository.findByEmail(username);
        List<GrantAuthorityImpl> grantAuthorityList = new ArrayList<>();
        Set<Role> roles = user.getRoles();

        roles.forEach(role ->
                {
                    grantAuthorityList.add(new GrantAuthorityImpl(role.getAuthority()));
                }
        );
        if (username != null) {
            return new AppUser(user.getEmail(),
                    user.getPassword(),
                    grantAuthorityList);
        } else {
            throw new RuntimeException();
        }
    }
}