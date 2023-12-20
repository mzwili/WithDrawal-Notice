package com.enviro.assessment.grad001.ThuthukaniMthiyane.service;

import com.enviro.assessment.grad001.ThuthukaniMthiyane.entity.Product;
import com.enviro.assessment.grad001.ThuthukaniMthiyane.interfaces.ProductService;
import com.enviro.assessment.grad001.ThuthukaniMthiyane.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProduct() {
        return this.productRepository.findAll();
    }
}
