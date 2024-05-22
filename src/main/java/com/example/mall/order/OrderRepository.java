package com.example.mall.order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Repository
public class OrderRepository {
    private final Map<Integer,Order> orderTable = new HashMap<>();
    private int id = 0;

    public Order save(Order order){

        log.info("productName = {}", order.getProduct().getName());
        log.info("count = {}", order.getCount());

        order.setId(id);
        orderTable.put(id++,order);

        return order;
    }
}
