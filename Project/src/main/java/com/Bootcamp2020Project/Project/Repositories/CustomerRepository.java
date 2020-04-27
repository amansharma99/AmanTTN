package com.Bootcamp2020Project.Project.Repositories;

import com.Bootcamp2020Project.Project.Entities.User.Customer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
public interface CustomerRepository extends CrudRepository<Customer,Long> {

    @Query("from Customer")
    List<Customer> findAllCustomer(Pageable pageable);

    @Query("from Customer where email=:username")
    Customer findByUsername(@Param("username") String username);


    @Transactional
    @Modifying
    @Query(value = "update Customer set firstName=:firstname ,middleName=:middleName ," +
            "lastName=:lastName ,contact=:contact where UserId=:id")
    void updateCustomer(@Param("id") Long id, @Param("firstname") String firstname,
                        @Param("middleName") String middleName, @Param("lastName") String lastName,
                        @Param("contact") Long contact);

    @Transactional
    @Modifying
    @Query(value = "update Customer set isActive=:isActive where email=:email")
    void updateIsActive(@Param("isActive") boolean is_active,@Param("email") String email);
}
