package com.akhambir.controllers;

import com.akhambir.dao.CategoryDao;
import com.akhambir.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.persistence.EntityNotFoundException;
import java.time.Duration;
import java.time.LocalDateTime;

import static org.springframework.http.MediaType.TEXT_EVENT_STREAM_VALUE;


@RestController
public class ReactiveCategoryController {

    @Autowired
    private CategoryDao categoryDao;

    @RequestMapping(value = "/category-mono/{id}", method = RequestMethod.GET)
    public Mono<Category> getCategoryById(@PathVariable Long id) {
        Category c = categoryDao.findById(id).orElseThrow(EntityNotFoundException::new);
        return Mono.create(ms -> ms.success(c));
    }

    @RequestMapping(value = "/category-flux", method = RequestMethod.GET, produces = TEXT_EVENT_STREAM_VALUE)
    public Flux<Category> getCategories() {
        /*return Flux.interval(Duration.ofMillis(1000))
                .map(seconds -> "\nFlux: " + LocalDateTime.now());*/
        return Flux.fromIterable(categoryDao.findAll())
                .delayElements(Duration.ofMillis(1000));
    }
}
