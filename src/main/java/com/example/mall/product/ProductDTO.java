package com.example.mall.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    private int id;

    @NotBlank(message = "상품명은 필수 입력입니다.")
    private String name;

    @NotNull(message = "상품 가격은 필수 입력입니다.")
    private int price;

    @NotNull(message = "카테고리 ID는 필수 입력입니다.")
    @JsonProperty("category_id")
    private int categoryId;

    @NotBlank(message = "상품설명은 필수 입력입니다.")
    private String description;

    public Product convertToEntity(){
        return new Product(
            name,price,categoryId,description
        );
    }
}
