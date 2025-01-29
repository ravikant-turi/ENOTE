package com.ENOTE_APP.service;

import com.ENOTE_APP.entity.Category;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface CategoryService  {

    public Boolean saveCategory(Category category);
    public List<Category> getAllCategory();


}
