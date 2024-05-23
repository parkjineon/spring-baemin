package com.example.mall.order;

import com.example.mall.member.Member;
import com.example.mall.member.MemberService;
import com.example.mall.utils.ApiUtils;
import com.example.mall.product.Product;
import com.example.mall.product.ProductService;
import com.example.mall.utils.Validator;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.example.mall.utils.ApiUtils.error;
import static com.example.mall.utils.ApiUtils.success;

@Slf4j
@AllArgsConstructor
@RestController
public class OrderController {
    OrderService orderService;
    ProductService productService;
    MemberService memberService;

    @PostMapping("/orders")
    public ApiUtils.ApiResult<String> orderProduct(@Valid @RequestBody OrderDTO orderDTO){

        Optional<Product> orderedProduct = productService.findProduct(orderDTO.getProductId());
        Optional<Member> member = memberService.findById(orderDTO.getUserId());

        if(orderedProduct.isEmpty()){
            return error("존재하지 않는 상품", HttpStatus.BAD_REQUEST);
        }else if(member.isEmpty()){
            return error("존재하지 않는 회원", HttpStatus.BAD_REQUEST);
        }

        Order requestOrder = new Order(member.get(), orderedProduct.get(), orderDTO.getCount());
        Order savedOrder = orderService.orderProduct(requestOrder);

        try {
            log.info(savedOrder.getProduct().getName());
        } catch (NullPointerException e) {
            return error("서버 내부 에러", HttpStatus.INTERNAL_SERVER_ERROR);
        }


        return success(savedOrder.getProduct().getName());

    }


    //주문 개별 조회
    @GetMapping("/orders/{id}")
    public ApiUtils.ApiResult findOrder(@PathVariable(value="id") int id) {

        if (!Validator.isNumber(id)) {
            return error("잘못된 요청",HttpStatus.BAD_REQUEST);
        }

        Optional<Order> resultOrder = orderService.findOrder(id);

        if (resultOrder.isEmpty())
            return error("존재하지 않는 주문",HttpStatus.NOT_FOUND);

        return success(resultOrder.get());
    }


    //주문 전체 조회(회원 id)
    @GetMapping("/orders")
    public ApiUtils.ApiResult findOrderByUserId(@RequestParam(value="userId") int id) {

        if (!Validator.isNumber(id)) {
            return error("잘못된 요청",HttpStatus.BAD_REQUEST);
        }

        Optional<Member> member = memberService.findById(id);
        if(member.isEmpty()){
            return error("존재하지 않는 회원",HttpStatus.NOT_FOUND);
        }

        List<Order> resultOrders = orderService.findOrderByUser(member.get());

        return success(resultOrders);
    }
}
