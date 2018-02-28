package com.khanchych.sandbox.checkmanytomanyextrafields.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Test2Category {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private Integer position;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="test_id", nullable = false)
    private Test test;

    @ManyToOne
    @JoinColumn(name="category_id", nullable = false)
    private Category category;

    public Long getId() {
        return id;
    }

    public Integer getPosition() {
        return position;
    }

    public Category getCategory() {
        return category;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
