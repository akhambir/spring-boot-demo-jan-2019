package com.akhambir.dao;

import com.akhambir.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import reactor.core.publisher.Mono;

import java.util.List;

public interface CategoryDao extends JpaRepository<Category, Long> {

    @Query("from Category c join fetch c.products")
    List<Category> getAllCategories();

    //Mono<Category> findCategoryMonoById(Long id);

}
