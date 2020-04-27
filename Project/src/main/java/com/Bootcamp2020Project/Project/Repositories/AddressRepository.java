package com.Bootcamp2020Project.Project.Repositories;


import com.Bootcamp2020Project.Project.Entities.User.Address;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AddressRepository extends CrudRepository<Address,Long> {

    @Query(value = "select * from Address where CustomerUserId=:customerUserId",nativeQuery =true )
    Set<Address> findAllAddressByCustomer(@Param("customerUserId")Long customerUserId);

    @Query(value = "select * from Address where id=:addressId and CustomerUserId=:customeruserId",nativeQuery = true)
    Address findByUserIdAndAddressId(@Param("addressId")Long addressId,@Param("customeruserId")Long userId);

    @Query(value = "select * from Address where id=:addressId and SellerUserId=:selleruserId",nativeQuery = true)
    Address findBySellerIdAndAddressId(@Param("addressId")Long addressId,@Param("selleruserId")Long userId);

    @Query(value = "select * from Address where SellerUserId=:selleruserId",nativeQuery = true)
    Address findAddressBySeller(@Param("selleruserId") Long id);
}
