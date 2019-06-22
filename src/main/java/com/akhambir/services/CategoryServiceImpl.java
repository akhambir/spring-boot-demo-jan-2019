package com.akhambir.services;

import com.akhambir.dao.CategoryDao;
import com.akhambir.model.Category;
import com.akhambir.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {


    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Optional<List<Category>> getAll() {
        return Optional.of(categoryDao.findAll());
    }

    @Override
    public Optional<List<Category>> test() {
        List<Category> result = categoryDao.findAll();
        for (Category c: result) {
            List<Product> products = c.getProducts();
            for (Product p : products) {
                System.out.println(p.getProductName());
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Category> getById(Long id) {
        return categoryDao.findById(id);
    }

    @Override
    public Optional<Category> create(Category category) {
        return Optional.of(categoryDao.save(category));
    }

    @Override
    public Optional<Category> update(Category category) {
        return Optional.of(categoryDao.save(category));
    }
}
