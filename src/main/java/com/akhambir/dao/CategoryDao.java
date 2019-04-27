package com.akhambir.dao;

import com.akhambir.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import reactor.core.publisher.Mono;

public interface CategoryDao extends JpaRepository<Category, Long> {

    //Mono<Category> findCategoryMonoById(Long id);

}
