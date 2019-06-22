package com.akhambir.controllers;

import com.akhambir.model.Category;
import com.akhambir.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

import static com.akhambir.controllers.ControllersUtil.getUri;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public ResponseEntity<List<Category>> getAll() {
        return categoryService.getAll()
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }
    @RequestMapping(value = "/category-test", method = RequestMethod.GET)
    public ResponseEntity<String> test() {
        categoryService.test();
        return ResponseEntity.ok("TEST");
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
    public ResponseEntity<Category> getById(@PathVariable Long id) {
        return categoryService.getById(id)
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }

    @RequestMapping(value = "/category", method = RequestMethod.POST)
    public ResponseEntity<Category> create(@Valid @RequestBody Category category) {
        return categoryService.create(category)
                .map(c -> ResponseEntity.created(getUri("category", c.getId())).body(c))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.CONFLICT));
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Category> update(@RequestBody Category category, @PathVariable Long id) {
        category.setId(id);
        return categoryService.update(category)
                .map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.CONFLICT));
    }
}
