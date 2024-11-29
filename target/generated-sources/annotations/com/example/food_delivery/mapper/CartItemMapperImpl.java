package com.example.food_delivery.mapper;

import com.example.food_delivery.dto.CartItemDto;
import com.example.food_delivery.dto.food.FoodDto;
import com.example.food_delivery.entity.CartItem;
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
public class CartItemMapperImpl implements CartItemMapper {

    @Override
    public CartItemDto toDto(CartItem cartItem) {
        if ( cartItem == null ) {
            return null;
        }

        FoodDto food = null;
        Integer quantity = null;
        double itemPrice = 0.0d;

        food = foodToFoodDto( cartItem.getFood() );
        quantity = cartItem.getQuantity();
        itemPrice = cartItem.getItemPrice();

        CartItemDto cartItemDto = new CartItemDto( food, quantity, itemPrice );

        return cartItemDto;
    }

    @Override
    public List<CartItemDto> toDtoList(List<CartItem> items) {
        if ( items == null ) {
            return null;
        }

        List<CartItemDto> list = new ArrayList<CartItemDto>( items.size() );
        for ( CartItem cartItem : items ) {
            list.add( toDto( cartItem ) );
        }

        return list;
    }

    @Override
    public CartItem partialUpdate(CartItemDto cartItemDto, CartItem cartItem) {
        if ( cartItemDto == null ) {
            return cartItem;
        }

        if ( cartItemDto.food() != null ) {
            if ( cartItem.getFood() == null ) {
                cartItem.setFood( new Food() );
            }
            foodDtoToFood( cartItemDto.food(), cartItem.getFood() );
        }
        if ( cartItemDto.quantity() != null ) {
            cartItem.setQuantity( cartItemDto.quantity() );
        }
        cartItem.setItemPrice( cartItemDto.itemPrice() );

        return cartItem;
    }

    protected FoodDto foodToFoodDto(Food food) {
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

    protected void foodDtoToFood(FoodDto foodDto, Food mappingTarget) {
        if ( foodDto == null ) {
            return;
        }

        if ( foodDto.id() != null ) {
            mappingTarget.setId( foodDto.id() );
        }
        if ( foodDto.name() != null ) {
            mappingTarget.setName( foodDto.name() );
        }
        mappingTarget.setPrice( foodDto.price() );
        if ( foodDto.description() != null ) {
            mappingTarget.setDescription( foodDto.description() );
        }
        String[] ingredients = foodDto.ingredients();
        if ( ingredients != null ) {
            mappingTarget.setIngredients( Arrays.copyOf( ingredients, ingredients.length ) );
        }
    }
}
