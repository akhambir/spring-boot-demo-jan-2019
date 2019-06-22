package com.akhambir.services;

import com.akhambir.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    Optional<List<Category>> getAll();
    Optional<List<Category>> test();

    Optional<Category> getById(Long id);

    Optional<Category> create(Category category);

    Optional<Category> update(Category category);
}
