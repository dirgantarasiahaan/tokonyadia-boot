package com.mandiri.tokonyadia.service;

import com.mandiri.tokonyadia.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    public Page<Product> findAllProduct(Pageable pageable);
    public Product findProductById(String productId);
    public Product createNewProduct(Product product);
    public Product updateProduct(Product product);
    public List<Product> findALlProductByMerchantId(String merchantId);
}
