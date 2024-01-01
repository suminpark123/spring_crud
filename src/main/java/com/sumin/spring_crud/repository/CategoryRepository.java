package com.sumin.spring_crud.repository;

import com.sumin.spring_crud.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
