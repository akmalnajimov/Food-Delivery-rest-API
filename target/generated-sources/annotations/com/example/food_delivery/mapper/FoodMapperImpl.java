package com.example.food_delivery.mapper;

import com.example.food_delivery.dto.food.FoodCreateDto;
import com.example.food_delivery.dto.food.FoodDto;
import com.example.food_delivery.dto.food.FoodUpdateDto;
import com.example.food_delivery.entity.Food;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-21T16:40:20+0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class FoodMapperImpl implements FoodMapper {

    @Override
    public Food toEntity(FoodCreateDto foodCreateDto) {
        if ( foodCreateDto == null ) {
            return null;
        }

        Food food = new Food();

        food.setName( foodCreateDto.name() );
        food.setPrice( foodCreateDto.price() );
        food.setDescription( foodCreateDto.description() );
        String[] ingredients = foodCreateDto.ingredients();
        if ( ingredients != null ) {
            food.setIngredients( Arrays.copyOf( ingredients, ingredients.length ) );
        }

        return food;
    }

    @Override
    public FoodDto toDto(Food food) {
        if ( food == null ) {
            return null;
        }

        Integer id = null;
        String name = null;
        double price = 0.0d;
        String description = null;
        String[] ingredients = null;

        id = food.getId();
        name = food.getName();
        price = food.getPrice();
        description = food.getDescription();
        String[] ingredients1 = food.getIngredients();
        if ( ingredients1 != null ) {
            ingredients = Arrays.copyOf( ingredients1, ingredients1.length );
        }

        FoodDto foodDto = new FoodDto( id, name, price, description, ingredients );

        return foodDto;
    }

    @Override
    public List<FoodDto> toDtoList(List<Food> foodList) {
        if ( foodList == null ) {
            return null;
        }

        List<FoodDto> list = new ArrayList<FoodDto>( foodList.size() );
        for ( Food food : foodList ) {
            list.add( toDto( food ) );
        }

        return list;
    }

    @Override
    public Food partialUpdate(FoodUpdateDto foodUpdateDto, Food food) {
        if ( foodUpdateDto == null ) {
            return food;
        }

        if ( foodUpdateDto.name() != null ) {
            food.setName( foodUpdateDto.name() );
        }
        food.setPrice( foodUpdateDto.price() );
        if ( foodUpdateDto.description() != null ) {
            food.setDescription( foodUpdateDto.description() );
        }
        String[] ingredients = foodUpdateDto.ingredients();
        if ( ingredients != null ) {
            food.setIngredients( Arrays.copyOf( ingredients, ingredients.length ) );
        }

        return food;
    }
}
