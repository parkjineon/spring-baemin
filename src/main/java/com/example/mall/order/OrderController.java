package com.example.mall.order;

import com.example.mall.product.Product;
import com.example.mall.product.ProductRepository;
import com.example.mall.product.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class OrderController {
    OrderService orderService;
    ProductService productService;

    @PostMapping("/orders")
    public void order(@RequestBody OrderDTO orderDTO){
        Product orderedProduct = productService.findProduct(orderDTO.getProductId());

        Order requestOrder = new Order(orderedProduct, orderDTO.getCount());

        orderService.order(requestOrder);

    }
}
