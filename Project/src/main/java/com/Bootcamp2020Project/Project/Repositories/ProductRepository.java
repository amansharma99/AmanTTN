package com.Bootcamp2020Project.Project.Repositories;

import com.Bootcamp2020Project.Project.Entities.Product.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {
}
