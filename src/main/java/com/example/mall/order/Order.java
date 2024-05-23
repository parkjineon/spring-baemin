package com.example.mall.order;


import com.example.mall.member.Member;
import com.example.mall.product.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "`Order`")
@RequiredArgsConstructor
public class Order {

    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name="productId")
    private Product product;

    @ManyToOne
    @JoinColumn(name="userId")
    private Member member;

    private int count;

    public Order(Member member, Product product, int count){
        this.member = member;
        this.product = product;
        this.count = count;
    }
}
