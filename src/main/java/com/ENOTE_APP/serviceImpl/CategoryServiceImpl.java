package com.ENOTE_APP.serviceImpl;

import com.ENOTE_APP.entity.Category;
import com.ENOTE_APP.repository.CategoryRepository;
import com.ENOTE_APP.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired private CategoryRepository categoryRepository;

    @Override
    public Boolean saveCategory(Category category) {
        category.setDeleted(false);
        category.setCreatedOn(new Date());
        category.setCreatedBy(1);
      Category saveCategory=this.categoryRepository.save(category);
       if (ObjectUtils.isEmpty(saveCategory)){
           return false;
       }
       return true;
    }

    @Override
    public List<Category> getAllCategory() {
        return this.categoryRepository.findAll();
    }
}
