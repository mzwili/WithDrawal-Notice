package com.enviro.assessment.grad001.ThuthukaniMthiyane.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import com.enviro.assessment.grad001.ThuthukaniMthiyane.entity.Product;
import com.enviro.assessment.grad001.ThuthukaniMthiyane.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    public void testGetAllProduct() {
        // Arrange
        Product product1 = new Product();
        product1.setId(1);
        product1.setType("savings");
        product1.setName("Save Fund");
        product1.setBalance(230000);
        Product product2 = new Product();
        product2.setId(2);
        product1.setType("retirement");
        product1.setName("Retire Fund");
        product1.setBalance(230000);
        List<Product> productList = Arrays.asList(product1, product2);

        // Mock the behavior of the productRepository.findAll() method
        when(productRepository.findAll()).thenReturn(productList);

        // Act
        List<Product> result = productService.getAllProduct();

        // Assert
        // Verify that the findAll() method of productRepository was called once
        verify(productRepository, times(1)).findAll();
        // Verify that the result matches the expected productList
        assertEquals(productList, result);
    }

}