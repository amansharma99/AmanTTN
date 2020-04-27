package com.Bootcamp2020Project.Project.Repositories;


import com.Bootcamp2020Project.Project.Entities.User.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends CrudRepository<Admin,Long> {
}
