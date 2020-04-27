package com.Bootcamp2020Project.Project.Repositories;

import com.Bootcamp2020Project.Project.Entities.Product.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {

    @Query(value = "select * from Product where id=:productId and SellerUserId=:userId", nativeQuery = true)
    Optional<Product> findByIdAndSellerId(@Param("userId") Long userid, @Param("productId") Long productId);

    @Query(value = "select * from Product where SellerUserId=:userId", nativeQuery = true)
    List<Product> findAllBySeller(@Param("userId") Long userId);

    @Query(value = "select * from Product where id=:productId and SellerUserId=:userId", nativeQuery = true)
    Product findByUserIdAndSellerId(@Param("productId") Long productId, @Param("userId") Long userId);

    @Transactional
    @Modifying
    @Query(value = "delete from product where id=:productId and SellerUserId=:userId", nativeQuery = true)
    void deleteByIdAndSellerId(@Param("productId") Long productId, @Param("userId") Long userId);

    @Transactional
    @Modifying
    @Query(value = "update product set isActive =:isActive  where id=:productId",nativeQuery = true)
    void deActivateProduct(@Param("productId") Long productId,@Param("isActive ") boolean is_active);

    @Transactional
    @Modifying
    @Query(value = "update product set isActive =:isActive  where id=:productId",nativeQuery = true)
    void activateProduct(@Param("productId") Long productId,@Param("isActive ") boolean is_active);
}
