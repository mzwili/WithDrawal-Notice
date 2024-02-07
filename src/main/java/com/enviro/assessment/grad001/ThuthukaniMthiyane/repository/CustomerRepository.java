package com.enviro.assessment.grad001.ThuthukaniMthiyane.repository;

import com.enviro.assessment.grad001.ThuthukaniMthiyane.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Customer findByEmail(String email);
    boolean existsByEmail(String email);
}
