package com.mandiri.tokonyadia.service;

import com.mandiri.tokonyadia.entity.Merchant;
import com.mandiri.tokonyadia.entity.Product;
import com.mandiri.tokonyadia.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    public static String notFoundMessage = "Product with ID : %s Not Found ";

    @Autowired
    ProductRepository productRepository;

    @Autowired
    MerchantService merchantService;

    @Override
    public Page<Product> findAllProduct(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Product findProductById(String productId) {
        validateProduct(productId);
        return productRepository.findById(productId).get();
    }

    @Override
    public Product createNewProduct(Product product) {
        product.setCreatedAt(new Timestamp(new Date().getTime()));
        product.setUpdatedAt(new Timestamp(new Date().getTime()));
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        product.setUpdatedAt(new Timestamp(new Date().getTime()));
        validateProduct(product.getId());
        return productRepository.save(product);
    }

    @Override
    public List<Product> findALlProductByMerchantId(String merchantId) {
        Merchant merchant = merchantService.findMerchantById(merchantId);
        return merchant.getProducts();
    }


    private void validateProduct(String productId) {
        if (!productRepository.findById(productId).isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format(notFoundMessage, productId));
        }
    }
}
