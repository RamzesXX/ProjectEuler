package com.khanchych.sandbox.checkmanytomanyextrafields.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE}, mappedBy = "category")
    @JsonIgnore
    private List<Test2Category> test2Categories;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
