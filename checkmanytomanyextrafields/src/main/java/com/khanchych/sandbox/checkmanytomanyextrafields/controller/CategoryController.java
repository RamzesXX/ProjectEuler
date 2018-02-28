package com.khanchych.sandbox.checkmanytomanyextrafields.controller;

import com.khanchych.sandbox.checkmanytomanyextrafields.domain.Category;
import com.khanchych.sandbox.checkmanytomanyextrafields.repository.CategoryRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("categories")
public class CategoryController {
    private CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    public Iterable<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @GetMapping("/{id}")
    public Category getCategory(@PathVariable("id") Long categoryId) {
        return categoryRepository.findOne(categoryId);
    }

    @PostMapping
    public Category save(@RequestBody Category category) {
        return categoryRepository.save(category);
    }

    @PatchMapping
    public Category update(@RequestBody Category category) {
        return categoryRepository.save(category);
    }

    @DeleteMapping
    public void delete(Long categoryId) {
        categoryRepository.delete(categoryId);
    }
}
