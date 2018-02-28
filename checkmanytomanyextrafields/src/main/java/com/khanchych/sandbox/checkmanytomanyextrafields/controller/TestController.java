package com.khanchych.sandbox.checkmanytomanyextrafields.controller;

import com.khanchych.sandbox.checkmanytomanyextrafields.domain.Category;
import com.khanchych.sandbox.checkmanytomanyextrafields.domain.Test;
import com.khanchych.sandbox.checkmanytomanyextrafields.repository.TestRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tests")
public class TestController {
    private TestRepository testRepository;

    public TestController(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @GetMapping
    public Iterable<Test> getTests() {
        return testRepository.findAll();
    }

    @GetMapping("/{id}")
    public Test getTest(@PathVariable("id") Long testId) {
        Test test = testRepository.findOne(testId);

        if (test != null) {
            test.fetchCategories();
        }
        return test;
    }

    @PostMapping
    public Test save(@RequestBody Test test) {
        return testRepository.save(test);
    }

    @PatchMapping
    public Test update(@RequestBody Test test) {
        return testRepository.save(test);
    }

    @DeleteMapping
    public void delete(Long testId) {
        testRepository.delete(testId);
    }
}
