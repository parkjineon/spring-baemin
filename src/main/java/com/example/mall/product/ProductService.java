package com.example.mall.product;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Service
@AllArgsConstructor // 필드로 생성자 코드 구현
public class ProductService {
    ProductRepository productRepository;

    public Product registerProduct(Product product) {
        System.out.println("/products : service - " + product.getName());
        return productRepository.save(product);
    }

    public Product findProduct(int id) {
        return productRepository.findById(id);
    }

    public Page<Product> findProducts(int limit, int currentPage, Integer categoryId){
        Pageable pageable = PageRequest.of(currentPage, limit);
        return productRepository.findAllByCategoryId(categoryId,pageable);
    }

    public Page<Product> findProducts(int limit, int currentPage){
        PageRequest pageable = PageRequest.of(currentPage, limit);
        return productRepository.findAll(pageable);
    }

    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

    public void deleteProducts(List<Integer> productIds) {
        productRepository.deleteByIdIn(productIds);
    }
}
