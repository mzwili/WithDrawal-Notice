package com.enviro.assessment.grad001.ThuthukaniMthiyane.service;

import com.enviro.assessment.grad001.ThuthukaniMthiyane.dto.InvestDTO;
import com.enviro.assessment.grad001.ThuthukaniMthiyane.entity.Product;
import com.enviro.assessment.grad001.ThuthukaniMthiyane.interfaces.ProductService;
import com.enviro.assessment.grad001.ThuthukaniMthiyane.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    private Product newProduct;

    @Override
    public List<Product> getAllProduct() {
        try {
            return this.productRepository.findAll();
        }catch (RuntimeException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(),e);
        }
    }

    public void createProduct(InvestDTO investDTO){
       try {
           newProduct = new Product();
           newProduct.setName(investDTO.getName());
           newProduct.setType(investDTO.getType());
           newProduct.setBalance(investDTO.getAmount());
           productRepository.save(newProduct);
       }catch (RuntimeException ex){
           throw new RuntimeException("Create Product Error "+ex.getMessage());
       }

    }

}
