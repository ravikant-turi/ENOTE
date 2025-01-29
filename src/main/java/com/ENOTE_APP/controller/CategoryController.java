package com.ENOTE_APP.controller;
import com.ENOTE_APP.entity.Category;
import com.ENOTE_APP.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    @Autowired private CategoryService categoryService;


    @PostMapping("/save-category")
    private ResponseEntity<String> saveCategory(@RequestBody Category category){

        if(this.categoryService.saveCategory(category)){
            return new ResponseEntity<>("saved successfully",HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>("not saved",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/getAll-category")
    private ResponseEntity<List<Category>> getAllCategory(){

       return new ResponseEntity<>(this.categoryService.getAllCategory(), HttpStatus.OK);
    }

}
