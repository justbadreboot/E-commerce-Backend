package com.microservice.product;

import com.microservice.product.entity.Category;
import com.microservice.product.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductTestQuery {

    @InjectMocks
    private Category category;

    @Mock
    private CategoryRepository categoryRepository;

    @Test
    void verCategorias(){
        when(categoryRepository.findAll()).thenReturn(Arrays.asList(category));
        assertNotNull(categoryRepository.findAll());
    }
}
