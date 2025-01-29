package com.ENOTE_APP.repository;

import com.ENOTE_APP.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Integer> {


    List<Category> findByisActiveTrue();
}
