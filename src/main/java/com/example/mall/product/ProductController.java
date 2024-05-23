package com.example.mall.product;

import com.example.mall.utils.ApiUtils;
import com.example.mall.utils.Validator;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.example.mall.utils.ApiUtils.error;
import static com.example.mall.utils.ApiUtils.success;


@Slf4j
@RestController
@AllArgsConstructor  // 필드로 생성자 구현
public class ProductController {
    @Autowired
    ProductService productService;


    // 상품 개별 등록
    @PostMapping("/products")
    public ApiUtils.ApiResult<String> registerProduct(@Valid @RequestBody ProductDTO productDTO) {

        if (Validator.isAlpha(productDTO.getName()) && Validator.isNumber(productDTO.getPrice())) {
            log.info(productDTO.getName());

            Product requestProduct = productDTO.convertToEntity();

            Product savedProduct = productService.registerProduct(requestProduct);

            try {
                log.info(savedProduct.getName());
            } catch (NullPointerException e) {
                return error("서버 내부 에러",HttpStatus.INTERNAL_SERVER_ERROR);
            }

            return success(savedProduct.getName());
        } else {
            return error("잘못된 요청",HttpStatus.BAD_REQUEST);
        }
    }

    // 상품 전체, 카테고리별 조회
    @GetMapping("products")
    public ApiUtils.ApiResult<List<Product>> findProducts(
            @RequestParam(value="limit", defaultValue = "5") int limit,
            @RequestParam(value="currentPage", defaultValue = "0") int currentPage,
            @RequestParam(value="categoryId", required = false) Integer categoryId){

        log.info("limit={}",limit);
        log.info("currentPage={}", currentPage);
        log.info("categoryId = {}", categoryId);

        if(categoryId ==  null){
            Page<Product> resultProducts = productService.findProducts(limit, currentPage);
            return success(resultProducts.getContent());
        }else{
            Page<Product> resultProducts = productService.findProducts(limit, currentPage, categoryId);
            return success(resultProducts.getContent());
        }

    }

    // 상품 개별 조회
    @GetMapping("/products/{id}")
    public ApiUtils.ApiResult findProduct(@PathVariable(value="id") int id) {

        if (!Validator.isNumber(id)) {
            return error("잘못된 요청",HttpStatus.BAD_REQUEST);
        }

        Optional<Product> resultProduct = productService.findProduct(id);

        if (resultProduct.isEmpty())
            return error("존재하지 않는 상품",HttpStatus.NOT_FOUND);

        return success(resultProduct.get());
    }

    @DeleteMapping("/products/{id}")
    public ApiUtils.ApiResult<String> deleteProduct(@PathVariable(value="id") int id) {
        if(!Validator.isNumber(id)){
            return error("잘못된 요청",HttpStatus.BAD_REQUEST);
        }
        productService.deleteProduct(id);
        Optional<Product> product = productService.findProduct(id);

        if(product.isEmpty())
            return success("삭제 완료");
        else
            return error("서버 내부 에러",HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/products/delete")
    public ApiUtils.ApiResult<String> deleteProducts(@RequestBody Map<String, List<Integer>> deleteRequest){
        List<Integer> productIds = deleteRequest.get("productIds");

        if(productIds.isEmpty()){
            return error("잘못된 요청",HttpStatus.BAD_REQUEST);
        }

        productService.deleteProducts(productIds);

        return success("삭제 완료");
    }
}
