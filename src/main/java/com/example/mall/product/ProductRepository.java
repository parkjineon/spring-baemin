package com.example.mall.product;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    public Product findById(int id);

    public Page<Product> findAllByCategoryId(Integer categoryId,Pageable pageable);

    public Page<Product> findAll(Pageable pageable);

    public void deleteById(int id);

    @Transactional
    @Modifying
    public void deleteByIdIn(List<Integer> ids);
}