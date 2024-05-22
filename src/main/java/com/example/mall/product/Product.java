package com.example.mall.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private int id;
    private String name;
    private int price;
    private int categoryId;
    private String description;

}
