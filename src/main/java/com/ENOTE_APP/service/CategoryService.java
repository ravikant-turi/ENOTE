package com.ENOTE_APP.service;

import com.ENOTE_APP.dto.CategoryDto;
import com.ENOTE_APP.dto.CategoryResponse;
import com.ENOTE_APP.entity.Category;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface CategoryService  {

    public Boolean saveCategory(CategoryDto category);
    public List<CategoryDto> getAllCategory();


    List<CategoryResponse> getActiveCategory();

    CategoryDto getCategoryByID(Integer id);

    CategoryDto deletedCategoryByID(Integer id);
}
