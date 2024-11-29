package com.example.food_delivery.mapper;

import com.example.food_delivery.dto.OrderCreateDto;
import com.example.food_delivery.dto.OrderDto;
import com.example.food_delivery.dto.OrderItemDto;
import com.example.food_delivery.dto.food.FoodDto;
import com.example.food_delivery.entity.Food;
import com.example.food_delivery.entity.Order;
import com.example.food_delivery.entity.OrderItem;
import com.example.food_delivery.enums.ORDER_STATUS;
import java.time.LocalDateTime;
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
public class OrderMapperImpl implements OrderMapper {

    @Override
    public Order toEntity(OrderCreateDto orderCreateDto) {
        if ( orderCreateDto == null ) {
            return null;
        }

        Order order = new Order();

        order.setPhoneNumber( orderCreateDto.phoneNumber() );
        order.setFullName( orderCreateDto.fullName() );
        order.setAddress( orderCreateDto.address() );

        return order;
    }

    @Override
    public OrderDto toDto(Order order) {
        if ( order == null ) {
            return null;
        }

        Integer id = null;
        List<OrderItemDto> items = null;
        LocalDateTime orderDateTime = null;
        double totalAmount = 0.0d;
        String address = null;
        ORDER_STATUS status = null;

        id = order.getId();
        items = orderItemListToOrderItemDtoList( order.getItems() );
        orderDateTime = order.getOrderDateTime();
        totalAmount = order.getTotalAmount();
        address = order.getAddress();
        status = order.getStatus();

        OrderDto orderDto = new OrderDto( id, items, orderDateTime, totalAmount, address, status );

        return orderDto;
    }

    @Override
    public List<OrderDto> toDto(List<Order> orders) {
        if ( orders == null ) {
            return null;
        }

        List<OrderDto> list = new ArrayList<OrderDto>( orders.size() );
        for ( Order order : orders ) {
            list.add( toDto( order ) );
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

    protected OrderItemDto orderItemToOrderItemDto(OrderItem orderItem) {
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

    protected List<OrderItemDto> orderItemListToOrderItemDtoList(List<OrderItem> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderItemDto> list1 = new ArrayList<OrderItemDto>( list.size() );
        for ( OrderItem orderItem : list ) {
            list1.add( orderItemToOrderItemDto( orderItem ) );
        }

        return list1;
    }
}
