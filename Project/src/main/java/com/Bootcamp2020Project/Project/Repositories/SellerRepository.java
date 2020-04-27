package com.Bootcamp2020Project.Project.Repositories;

import com.Bootcamp2020Project.Project.Entities.User.Seller;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
public interface SellerRepository extends CrudRepository<Seller,Long> {
    @Query("from Seller")
    List<Seller> findAllSeller(Pageable pageable);

    @Query("from Seller where email=:username")
    Seller findByUsername(@Param("username") String username);

    @Query(value = "select id from Seller where id=:id",nativeQuery = true)
    Integer sellerUserId(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query(value = "update Seller set firstName=:firstname ,middleName=:middleName ," +
            "lastName=:lastName ,GST=:gst ,companyName=:companyname ," +
            "companyContact=:companycontact where id=:id")
    void updateSeller(@Param("id") Long id,@Param("firstname") String firstname,
                      @Param("middleName") String middleName,@Param("lastName") String lastName,
                      @Param("gst") String gst,@Param("companyname") String companyName,
                      @Param("companycontact") Long companyContact);

}
