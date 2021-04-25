package com.mandiri.tokonyadia.service;

import com.mandiri.tokonyadia.entity.Merchant;
import com.mandiri.tokonyadia.entity.Product;
import com.mandiri.tokonyadia.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class MerchantServiceImpl implements MerchantService{

    private static String notFoundMessage = "Customer with ID : %s Not Found";

    @Autowired
    MerchantRepository merchantRepository;

    @Autowired
    ProductService productService;

    @Override
    public Page<Merchant> findAllMerchant(Pageable pageable) {
        return merchantRepository.findAll(pageable);
    }

    @Override
    public Merchant createNewMerchant(Merchant merchant) {
        merchant.setCreatedAt(new Timestamp(new Date().getTime()));
        merchant.setUpdatedAt(new Timestamp(new Date().getTime()));
        for (Product product: merchant.getProducts()) {
            product.setCreatedAt(new Timestamp(new Date().getTime()));
            product.setUpdatedAt(new Timestamp(new Date().getTime()));
        }
        return merchantRepository.save(merchant);
    }

    @Override
    public Merchant findMerchantById(String merchantId) {
        validateMerchant(merchantId);
        Merchant merchant = merchantRepository.findById(merchantId).get();
        return merchant;
    }

    @Override
    public Merchant updateMerchant(Merchant merchant) {
        merchant.setUpdatedAt(new Timestamp(new Date().getTime()));
        for (Product product: merchant.getProducts()) {
            product.setUpdatedAt(new Timestamp(new Date().getTime()));
        }
        validateMerchant(merchant.getId());
        return merchantRepository.save(merchant);
    }

    private void validateMerchant(String merchantId) {
        if (!merchantRepository.findById(merchantId).isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format(notFoundMessage, merchantId));
        }
    }
}
