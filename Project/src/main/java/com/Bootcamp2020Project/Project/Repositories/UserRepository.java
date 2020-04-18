package com.Bootcamp2020Project.Project.Repositories;


import com.Bootcamp2020Project.Project.Entities.User.Users;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface UserRepository extends CrudRepository<Users, Long> {

    Users findByEmail(String email);
    @Query("from Users where email=:username")
    Users findByUsername(@Param("username") String username);

    @Transactional
    @Modifying
    @Query(value = "update Users set password=:password where email=:email")
    void updatePassword(@Param("password") String password,@Param("email") String email);


}