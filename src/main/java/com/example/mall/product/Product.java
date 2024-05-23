package com.example.mall.product;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
@Entity
public class Product {
    @Id
    private int id;
    private String name;
    private int price;
    private int categoryId;
    private String description;

    @Autowired
    public Product(){}

    public Product(String name, int price, int categoryId, String description){
        this.name = name;
        this.price = price;
        this.categoryId = categoryId;
        this.description = description;
    }
}
