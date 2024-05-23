package com.example.mall.order;

import com.example.mall.member.Member;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class OrderService {
    OrderRepository orderRepository;

    public Order orderProduct(Order order){
        return orderRepository.save(order);
    }

    public Optional<Order> findOrder(int id) {
        return orderRepository.findById(id);
    }

    public List<Order> findOrderByUser(Member member) {
        return orderRepository.findAllByMember(member);
    }
}
