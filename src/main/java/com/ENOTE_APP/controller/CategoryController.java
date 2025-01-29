package com.ENOTE_APP.controller;
import com.ENOTE_APP.dto.CategoryDto;
import com.ENOTE_APP.dto.CategoryResponse;
import com.ENOTE_APP.entity.Category;
import com.ENOTE_APP.service.CategoryService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    @Autowired private CategoryService categoryService;


    @PostMapping("/save-category")
    private ResponseEntity<String> saveCategory(@RequestBody CategoryDto categoryDto){

        System.out.println("active"+categoryDto.getActive());

        if(this.categoryService.saveCategory(categoryDto)){
            return new ResponseEntity<>("saved successfully",HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>("not saved",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/getAll-category")
    private ResponseEntity<List<CategoryDto>> getAllCategory(){

       return new ResponseEntity<>(this.categoryService.getAllCategory(), HttpStatus.OK);
    }

    @GetMapping("/get-active-category")
    private ResponseEntity<List<CategoryResponse>>getActiveCategory(){
        return new ResponseEntity<>(this.categoryService.getActiveCategory(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryDetailById(@PathVariable Integer id){
        CategoryDto categoryDto=categoryService.getCategoryByID(id);
        if (ObjectUtils.isEmpty(categoryDto)){
            return new ResponseEntity<>("user not found",HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(categoryDto,HttpStatus.OK);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> DeleteCategoryDetailById(@PathVariable Integer id){
        CategoryDto categoryDto=categoryService.deletedCategoryByID(id);
        if (ObjectUtils.isEmpty(categoryDto)){
            return new ResponseEntity<>("user not found",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        else {
            return new ResponseEntity<>(categoryDto,HttpStatus.OK);
        }
    }

}
