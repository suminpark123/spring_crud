package com.sumin.spring_crud.service.impl;


import com.sumin.spring_crud.exception.ResourceNotFoundException;
import com.sumin.spring_crud.model.Category;
import com.sumin.spring_crud.payload.CategoryDto;
import com.sumin.spring_crud.repository.CategoryRepository;
import com.sumin.spring_crud.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {



    private CategoryRepository categoryRepository;

    private ModelMapper mapper;


    public  CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper mapper){

        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
    }

    //이해해야됨,
    @Override
    public CategoryDto createCategroy(CategoryDto categoryDto) {
         Category category = mapper.map(categoryDto, Category.class);
         Category savedCategory = categoryRepository.save(category);
        return mapper.map(savedCategory, CategoryDto.class);
    }

    @Override
    public List<Category> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories;
    }

    @Override
    public CategoryDto getCategoryById(long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("category","id",id));

        return mapper.map(category, CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategoryById(long id, CategoryDto categoryDto) {
        return null;
    }

    @Override
    public String delateCategoryById(long id) {
        return null;
    }



}
