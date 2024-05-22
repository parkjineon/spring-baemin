package com.example.mall.order;


import com.example.mall.product.Product;
import com.example.mall.product.ProductRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Order {

    Order(Product product, int count){
        this.product = product;
        this.count = count;
    }

    int id;
    Product product;
    int count;
}
