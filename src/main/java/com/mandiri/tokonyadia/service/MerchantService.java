package com.mandiri.tokonyadia.service;

import com.mandiri.tokonyadia.dto.MerchantCustomerDto;
import com.mandiri.tokonyadia.entity.Merchant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface MerchantService {

    public Page<Merchant> findAllMerchant(Pageable pageable);
    public Merchant findMerchantById(String merchantId);
    public Merchant createNewMerchant(Merchant merchant);
    public Merchant updateMerchant(Merchant merchant);
    public List<MerchantCustomerDto> getCustomersByMerchantId(String merchantId);

}
