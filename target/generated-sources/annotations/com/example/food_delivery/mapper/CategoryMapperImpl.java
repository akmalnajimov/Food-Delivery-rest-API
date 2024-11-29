package com.example.food_delivery.mapper;

import com.example.food_delivery.dto.category.CategoryCreateDto;
import com.example.food_delivery.dto.category.CategoryDto;
import com.example.food_delivery.dto.category.CategoryUpdateDto;
import com.example.food_delivery.entity.Category;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-21T16:40:20+0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public Category toEntity(CategoryCreateDto categoryCreateDto) {
        if ( categoryCreateDto == null ) {
            return null;
        }

        Category category = new Category();

        category.setName( categoryCreateDto.name() );
        category.setDescription( categoryCreateDto.description() );

        return category;
    }

    @Override
    public CategoryDto toDto(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setId( category.getId() );
        categoryDto.setName( category.getName() );
        categoryDto.setDescription( category.getDescription() );

        return categoryDto;
    }

    @Override
    public List<CategoryDto> toDtoList(List<Category> categoryList) {
        if ( categoryList == null ) {
            return null;
        }

        List<CategoryDto> list = new ArrayList<CategoryDto>( categoryList.size() );
        for ( Category category : categoryList ) {
            list.add( toDto( category ) );
        }

        return list;
    }

    @Override
    public Category partialUpdate(CategoryUpdateDto categoryUpdateDto, Category category) {
        if ( categoryUpdateDto == null ) {
            return category;
        }

        if ( categoryUpdateDto.name() != null ) {
            category.setName( categoryUpdateDto.name() );
        }
        if ( categoryUpdateDto.description() != null ) {
            category.setDescription( categoryUpdateDto.description() );
        }

        return category;
    }
}
