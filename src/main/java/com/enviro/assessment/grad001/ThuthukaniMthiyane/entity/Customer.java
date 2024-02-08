package com.enviro.assessment.grad001.ThuthukaniMthiyane.entity;

import jakarta.persistence.*;
import com.enviro.assessment.grad001.ThuthukaniMthiyane.entity.Product;

import java.util.List;

@Entity
@Table(name = "investor")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String fullName;
    private int age;
    private String email;

    private String contactNumber;

    private String password;


//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.ALL)
//    private List<Product> customerProducts;


//    public List<Product> getCustomerProducts() {
//        return customerProducts;
//    }
//
//    public void setCustomerProducts(List<Product> customerProducts) {
//        this.customerProducts = customerProducts;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String emailAddress) {
        this.email = emailAddress;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

}
