package com.khanchych.sandbox.checkmanytomanyextrafields.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Test {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE, CascadeType.PERSIST}, mappedBy = "test")
    private List<Test2Category> test2Categories;


    @Transient
    private List<Test2Category> categories = new ArrayList<>();

    @JsonIgnore
    public void fetchCategories(){
        categories = test2Categories;
    }

    public List<Test2Category> getCategories() {
        return categories;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonSetter("categories")
    public void setTest2Categories(List<Test2Category> test2Categories) {
        this.test2Categories = test2Categories;
    }
}
