package com.mandiri.tokonyadia.controller;


import com.mandiri.tokonyadia.dto.MerchantCustomerDto;
import com.mandiri.tokonyadia.entity.Merchant;
import com.mandiri.tokonyadia.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MerchantRestController {

    @Autowired
    MerchantService merchantService;

    @GetMapping("/merchants")
    public Page<Merchant> findAllMerchant(@RequestParam(name = "page", defaultValue = "0") Integer page,
                                          @RequestParam(name = "size", defaultValue = "10") Integer size){
        Pageable pageable = PageRequest.of(page, size);
        return merchantService.findAllMerchant(pageable);
    }

    @GetMapping("/merchant/{id}")
    public Merchant findMerchantById(@PathVariable(name = "id") String merchantId){
        return merchantService.findMerchantById(merchantId);
    }

    @PostMapping("/merchant")
    public Merchant createNew(@RequestBody Merchant merchant){
        return merchantService.createNewMerchant(merchant);
    }

    @PutMapping("/merchant")
    public Merchant updateMerchant(@RequestBody Merchant merchant){
        return merchantService.updateMerchant(merchant);
    }

    @GetMapping("merchant/{id}/customers")
    public List<MerchantCustomerDto> getCustomersByMerchantId(@PathVariable(name = "id") String id){
        return merchantService.getCustomersByMerchantId(id);
    }

}
