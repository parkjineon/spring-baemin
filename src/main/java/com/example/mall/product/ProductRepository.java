package com.example.mall.product;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProductRepository {
    Map<Integer, Product> productTable = new HashMap<>();

    int id = 0;

    public Product save(Product product) {

        product.setId(id++);
        productTable.put(product.getId(), product);
        System.out.println("/products : repository - " + productTable.get(id-1));

        return productTable.get(id-1);
    }

    public Product findProduct(int id) {
        return productTable.get(id);
    }

    public List<Product> findProducts(int limit, int currentPage, Integer categoryId){
        List<Product> resultProducts = new ArrayList<>();

        int count = 0;
        for(int i = (currentPage-1)*limit; i < id; i++){
            if(productTable.get(i) != null && productTable.get(i).getCategoryId() == categoryId){
                resultProducts.add(productTable.get(i));
                count++;
            }
            if(count == limit) break;
        }

        return resultProducts;
    }

    public List<Product> findProducts(int limit, int currentPage){
        List<Product> resultProducts = new ArrayList<>();

        int count = 0;
        for (int i = (currentPage - 1) * limit; i < id; i++) {
            if (productTable.get(i) != null) {
                resultProducts.add(productTable.get(i));
                count++;
            }
            if(count == limit) break;
        }

        return resultProducts;
    }

    public void deleteProduct(int id) {
        productTable.remove(id);
    }

    public void deleteProducts(List<Integer> productIds) {
        for(int i = 0; i < productIds.size(); i++){
            productTable.remove(productIds.get(i));
        }
    }
}