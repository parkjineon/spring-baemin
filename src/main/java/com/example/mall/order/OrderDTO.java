package com.example.mall.order;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Getter
@Setter
public class OrderDTO {

    @NotNull(message = "상품 Id는 필수 입력입니다.")
    private Integer productId;

    @NotNull(message = "회원 Id는 필수 입력입니다.")
    private Integer userId;

    @NotNull(message = "상품 개수는 필수 입력입니다.")
    private Integer count;

}
