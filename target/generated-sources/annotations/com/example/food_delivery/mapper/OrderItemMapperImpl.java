package com.example.food_delivery.mapper;

import com.example.food_delivery.dto.OrderItemDto;
import com.example.food_delivery.dto.food.FoodDto;
import com.example.food_delivery.entity.Food;
import com.example.food_delivery.entity.OrderItem;
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
public class OrderItemMapperImpl implements OrderItemMapper {

    @Override
    public OrderItemDto toDto(OrderItem orderItem) {
        if ( orderItem == null ) {
            return null;
        }

        FoodDto food = null;
        Integer quantity = null;
        double itemPrice = 0.0d;

        food = foodToFoodDto( orderItem.getFood() );
        quantity = orderItem.getQuantity();
        itemPrice = orderItem.getItemPrice();

        OrderItemDto orderItemDto = new OrderItemDto( food, quantity, itemPrice );

        return orderItemDto;
    }

    @Override
    public List<OrderItemDto> toDtoList(List<OrderItem> orderItems) {
        if ( orderItems == null ) {
            return null;
        }

        List<OrderItemDto> list = new ArrayList<OrderItemDto>( orderItems.size() );
        for ( OrderItem orderItem : orderItems ) {
            list.add( toDto( orderItem ) );
        }

        return list;
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
}
