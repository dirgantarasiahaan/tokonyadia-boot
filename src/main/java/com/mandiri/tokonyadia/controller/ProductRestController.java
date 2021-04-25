package com.mandiri.tokonyadia.controller;

import com.mandiri.tokonyadia.entity.Merchant;
import com.mandiri.tokonyadia.entity.Product;
import com.mandiri.tokonyadia.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductRestController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public Page<Product> findAllProduct(@RequestParam(name = "page", defaultValue = "0") Integer page,
                                        @RequestParam(name = "size", defaultValue = "10") Integer size){
        Pageable pageable = PageRequest.of(page, size);
        return productService.findAllProduct(pageable);
    }

    @GetMapping("/product/{id}")
    public Product findProductById(@PathVariable(name = "id") String productId){
        return productService.findProductById(productId);
    }

    @GetMapping("/merchant/{id}/products")
    public List<Product> findAllproductByMerchantId(@PathVariable(name = "id") String merchantId){
        return productService.findALlProductByMerchantId(merchantId);
    }

    @PostMapping("/product")
    public Product createNewProduct(@RequestBody Product product){
        return productService.createNewProduct(product);
    }

    @PutMapping("/product")
    public Product updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }
}
