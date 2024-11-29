package com.example.food_delivery.mapper;

import com.example.food_delivery.dto.CartDto;
import com.example.food_delivery.dto.CartItemDto;
import com.example.food_delivery.dto.food.FoodDto;
import com.example.food_delivery.entity.Cart;
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
public class CartMapperImpl implements CartMapper {

    @Override
    public CartDto toDto(Cart cart) {
        if ( cart == null ) {
            return null;
        }

        List<CartItemDto> items = null;
        double totalPrice = 0.0d;

        items = cartItemListToCartItemDtoList( cart.getItems() );
        totalPrice = cart.getTotalPrice();

        CartDto cartDto = new CartDto( items, totalPrice );

        return cartDto;
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

    protected CartItemDto cartItemToCartItemDto(CartItem cartItem) {
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

    protected List<CartItemDto> cartItemListToCartItemDtoList(List<CartItem> list) {
        if ( list == null ) {
            return null;
        }

        List<CartItemDto> list1 = new ArrayList<CartItemDto>( list.size() );
        for ( CartItem cartItem : list ) {
            list1.add( cartItemToCartItemDto( cartItem ) );
        }

        return list1;
    }
}
