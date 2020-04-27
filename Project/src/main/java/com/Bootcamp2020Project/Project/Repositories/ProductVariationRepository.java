package com.Bootcamp2020Project.Project.Repositories;

import com.Bootcamp2020Project.Project.Entities.Product.ProductVariation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductVariationRepository extends CrudRepository<ProductVariation,Long> {
}
