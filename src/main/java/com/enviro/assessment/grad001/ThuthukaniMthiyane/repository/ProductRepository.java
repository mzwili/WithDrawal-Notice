package com.enviro.assessment.grad001.ThuthukaniMthiyane.repository;

import com.enviro.assessment.grad001.ThuthukaniMthiyane.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findProductByName(String name);
}
