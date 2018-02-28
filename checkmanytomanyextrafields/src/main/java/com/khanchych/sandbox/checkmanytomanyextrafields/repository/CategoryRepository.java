package com.khanchych.sandbox.checkmanytomanyextrafields.repository;

import com.khanchych.sandbox.checkmanytomanyextrafields.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository  extends CrudRepository<Category, Long>{
}
