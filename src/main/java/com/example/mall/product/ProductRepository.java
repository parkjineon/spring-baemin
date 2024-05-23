package com.example.mall.product;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    public Page<Product> findAllByCategoryId(Integer categoryId,Pageable pageable);

    @Transactional
    @Modifying
    public void deleteByIdIn(List<Integer> ids);
}