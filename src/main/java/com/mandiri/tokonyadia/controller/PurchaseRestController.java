package com.mandiri.tokonyadia.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mandiri.tokonyadia.entity.Purchase;
import com.mandiri.tokonyadia.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class PurchaseRestController {

    @Autowired
    PurchaseService purchaseService;

    @GetMapping("purchase/{id}")
    public Purchase findPurchaseById(@PathVariable(name = "id") String purchaseId){
        return purchaseService.findPurchaseById(purchaseId);
    }

    @GetMapping("purchases")
    public Page<Purchase> findAllPurchase(@RequestParam(name = "page", defaultValue = "0") Integer page,
                                          @RequestParam(name = "size", defaultValue = "10") Integer size){
        Pageable pageable = PageRequest.of(page, size);
        return purchaseService.findAllPurchase(pageable);
    }

    @PostMapping("customer/{id}/purchases")
    public Purchase createNewPurchase(@PathVariable(name = "id") String customerId,
                                      @RequestBody Purchase purchase) throws JsonProcessingException {
        purchase.setPurchaseDate(new Date());
        return purchaseService.createNewPurchase(purchase, customerId);
    }
}
