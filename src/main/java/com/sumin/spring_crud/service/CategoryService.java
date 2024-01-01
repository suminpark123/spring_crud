package com.sumin.spring_crud.service;

import com.sumin.spring_crud.model.Category;
import com.sumin.spring_crud.payload.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto createCategroy(CategoryDto categoryDto);

    List<Category> getAllCategories();

    CategoryDto getCategoryById(long id);

    CategoryDto updateCategoryById(long id,CategoryDto categoryDto);

    String delateCategoryById(long id);
}
