package com.mandiri.tokonyadia.service;

import com.mandiri.tokonyadia.entity.Merchant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface MerchantService {

    public Page<Merchant> findAllMerchant(Pageable pageable);
    public Merchant findMerchantById(String merchantId);
    public Merchant createNewMerchant(Merchant merchant);
    public Merchant updateMerchant(Merchant merchant);
}
