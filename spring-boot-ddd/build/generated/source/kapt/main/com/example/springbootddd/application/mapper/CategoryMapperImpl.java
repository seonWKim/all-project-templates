package com.example.springbootddd.application.mapper;

import com.example.springbootddd.application.dto.CategoryDto;
import com.example.springbootddd.domain.film.Category;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-26T21:22:14+0900",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from kotlin-annotation-processing-gradle-1.7.21.jar, environment: Java 11.0.14 (BellSoft)"
)
@Component
public class CategoryMapperImpl extends CategoryMapper {

    @Override
    public Category categoryDtoToCategory(CategoryDto categoryDto) {
        if ( categoryDto == null ) {
            return null;
        }

        Category category = new Category();

        category.setId( categoryDto.getId() );
        category.setName( categoryDto.getName() );
        category.setLastUpdate( categoryDto.getLastUpdate() );

        return category;
    }

    @Override
    public CategoryDto categoryToCategoryDto(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setId( category.getId() );
        categoryDto.setName( category.getName() );
        categoryDto.setLastUpdate( category.getLastUpdate() );

        return categoryDto;
    }

    @Override
    public Category updateCategoryFromCategoryDto(CategoryDto categoryDto, Category category) {
        if ( categoryDto == null ) {
            return category;
        }

        if ( categoryDto.getId() != null ) {
            category.setId( categoryDto.getId() );
        }
        if ( categoryDto.getName() != null ) {
            category.setName( categoryDto.getName() );
        }
        if ( categoryDto.getLastUpdate() != null ) {
            category.setLastUpdate( categoryDto.getLastUpdate() );
        }

        return category;
    }
}
