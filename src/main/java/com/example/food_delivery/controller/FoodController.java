package com.example.food_delivery.controller;

import com.example.food_delivery.dto.BaseResponse;
import com.example.food_delivery.dto.SearchDto;
import com.example.food_delivery.dto.food.FoodCreateDto;
import com.example.food_delivery.dto.food.FoodDto;
import com.example.food_delivery.dto.food.FoodUpdateDto;
import com.example.food_delivery.entity.Food;
import com.example.food_delivery.service.FoodService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FoodController {
    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping("/food")
    public BaseResponse<List<FoodDto>> getAll() {
        List<FoodDto> foodList = foodService.getAll();
        return new BaseResponse<>(foodList);
    }
    @GetMapping("/food/{id}")
    public BaseResponse<FoodDto> getById(@PathVariable Integer id){
        FoodDto food = foodService.getById(id);
        return new BaseResponse<>(food);
    }

    @DeleteMapping("/food/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        foodService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/food/update/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> update(@PathVariable Integer id,
                                       @Valid @RequestBody FoodUpdateDto dto) {
        foodService.update(dto, id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/category/{categoryId}/add-product")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public BaseResponse<Integer> save(@PathVariable Integer categoryId,
                                      @Valid @RequestBody FoodCreateDto dto) {
        Integer id = foodService.save(dto, categoryId);
        return new BaseResponse<>(id);
    }
    @GetMapping("/category/{categoryId}/foods")
    public BaseResponse<List<FoodDto>> getFoodListByCategoryId(@PathVariable Integer categoryId){
        return new BaseResponse<>(foodService.getByCategoryId(categoryId));
    }

    @PostMapping("/product/search")
    public BaseResponse<List<FoodDto>> search(@RequestBody SearchDto dto){
        return new BaseResponse<>(foodService.getBySearchResult(dto));
    }

    @GetMapping("/product/popular")
    public BaseResponse<List<FoodDto>> findByPopularity(){
        List<FoodDto> foodList = foodService.getFoodListByPopularity();
        return new BaseResponse<>(foodList);
    }
}
