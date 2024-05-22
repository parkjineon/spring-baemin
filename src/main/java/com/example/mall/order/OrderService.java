package com.example.mall.order;

import com.example.mall.product.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class OrderService {
    OrderRepository orderRepository;

    public void order(Order order){
        orderRepository.save(order);
    }

}
