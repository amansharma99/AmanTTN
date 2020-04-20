package com.Bootcamp2020Project.Project.Repositories;


import com.Bootcamp2020Project.Project.Entities.Product.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category,Long> {
}
