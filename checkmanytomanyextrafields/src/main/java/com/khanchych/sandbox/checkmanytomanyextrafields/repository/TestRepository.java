package com.khanchych.sandbox.checkmanytomanyextrafields.repository;

import com.khanchych.sandbox.checkmanytomanyextrafields.domain.Test;
import org.springframework.data.repository.CrudRepository;

public interface TestRepository extends CrudRepository<Test, Long> {
}
