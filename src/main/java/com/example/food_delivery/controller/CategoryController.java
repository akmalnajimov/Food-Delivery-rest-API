package com.example.food_delivery.controller;

import com.example.food_delivery.dto.BaseResponse;
import com.example.food_delivery.dto.category.CategoryCreateDto;
import com.example.food_delivery.dto.category.CategoryDto;
import com.example.food_delivery.dto.category.CategoryUpdateDto;
import com.example.food_delivery.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/category")
    public BaseResponse<List<CategoryDto>> getAllCategories() {
        List<CategoryDto> categoryList = categoryService.getAll();
        return new BaseResponse<>(categoryList);
    }

    @PostMapping("/category/add")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public BaseResponse<Integer> create(@Valid @RequestBody CategoryCreateDto categoryCreateDto) {
        Integer id = categoryService.save(categoryCreateDto);
        return new BaseResponse<>(id);
    }

    @PutMapping("/category/update/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> update(@Valid @RequestBody CategoryUpdateDto categoryUpdateDto, @PathVariable Integer id) {
        categoryService.update(categoryUpdateDto, id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/category/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}



