package com.ENOTE_APP.serviceImpl;

import com.ENOTE_APP.dto.CategoryDto;
import com.ENOTE_APP.dto.CategoryResponse;
import com.ENOTE_APP.entity.Category;
import com.ENOTE_APP.repository.CategoryRepository;
import com.ENOTE_APP.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired private CategoryRepository categoryRepository;
 @Autowired
    private ModelMapper modelMapper;

    @Override
    public Boolean saveCategory(CategoryDto categoryDto) {

        Category category=new Category();
        category.setDeleted(false);
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());
        category.setActive(categoryDto.getActive());
        category.setCreatedOn(new Date());
        category.setCreatedBy(1);
        Category saveCategory=this.categoryRepository.save(category);

       if (ObjectUtils.isEmpty(saveCategory)){
           return false;
       }
       return true;
    }

    @Override
    public List<CategoryDto> getAllCategory() {



      List<Category>  categoryList=categoryRepository.findAll();

     List<CategoryDto> categoryDtoList= categoryList.stream().map(category -> modelMapper.map(category,CategoryDto.class)).collect(Collectors.toList());

     return categoryDtoList;
    }

    @Override
    public List<CategoryResponse> getActiveCategory() {
        List<Category> categoryList=this.categoryRepository.findByisActiveTrue();
        return categoryList.stream().map(category -> modelMapper.map(category, CategoryResponse.class)).collect(Collectors.toList());


    }
}
