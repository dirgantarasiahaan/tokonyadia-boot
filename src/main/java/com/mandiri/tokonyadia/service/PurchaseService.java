package com.mandiri.tokonyadia.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mandiri.tokonyadia.entity.Purchase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.security.PublicKey;
import java.util.List;

public interface PurchaseService {

    public Purchase findPurchaseById(String purchaseId);
    public Page<Purchase> findAllPurchase(Pageable pageable);
    public Purchase createNewPurchase(Purchase purchase, String customerId) throws JsonProcessingException;

}
