package com.example.mall.product;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor // 필드로 생성자 코드 구현
public class ProductService {
    ProductRepository productRepository;

//    ProductService(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }

    public Product registerProduct(Product product) {
        System.out.println("/products : service - " + product.getName());
        return productRepository.save(product);
    }

    public Product findProduct(int id) {
        return productRepository.findProduct(id);
    }

    public List<Product> findProducts(int limit, int currentPage, Integer categoryId){
        return productRepository.findProducts(limit, currentPage,categoryId);
    }

    public List<Product> findProducts(int limit, int currentPage){
        return productRepository.findProducts(limit, currentPage);
    }

    public void deleteProduct(int id) {
        productRepository.deleteProduct(id);
    }

    public void deleteProducts(List<Integer> productIds) {
        productRepository.deleteProducts(productIds);
    }
}
