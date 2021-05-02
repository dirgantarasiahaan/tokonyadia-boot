package com.mandiri.tokonyadia.service;

import com.mandiri.tokonyadia.dto.MerchantCustomerDto;
import com.mandiri.tokonyadia.entity.Merchant;
import com.mandiri.tokonyadia.entity.Product;
import com.mandiri.tokonyadia.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;

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
            product.setMerchant(merchant);
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

    @Override
    public List<MerchantCustomerDto> getCustomersByMerchantId(String merchantId) {
        Merchant merchant = merchantRepository.findById(merchantId).get();
        return findCustomersShoppedAtMerchant(merchant);
    }

    private List<MerchantCustomerDto> findCustomersShoppedAtMerchant(Merchant merchant) {
        List<MerchantCustomerDto> merchantDtos = getMerchantDtos(merchant);
        List<MerchantCustomerDto> merchantDtoList = new ArrayList<>();
        LinkedHashMap<String, MerchantCustomerDto> map = new LinkedHashMap<>();
        for(MerchantCustomerDto m : merchantDtos){
            if(!map.containsKey(m.getCustomers().getId())) {
                map.put(m.getCustomers().getId(), m);
            }
            else {
                map.get(m.getCustomers().getId()).setAmount(map.get(m.getCustomers().getId()).getAmount().add(m.getAmount()));
            }
        }
        for(String n : map.keySet()){
            merchantDtoList.add(map.get(n));
        }
        return merchantDtoList;
    }

    private List<MerchantCustomerDto> getMerchantDtos(Merchant merchant) {
        List<MerchantCustomerDto> merchantDtos = new ArrayList<>();
        BigDecimal amount = new BigDecimal(0.0);
        for (int i = 0; i< merchant.getProducts().size(); i++) {
            for (int j = 0; j < merchant.getProducts().get(i).getPurchaseDetails().size(); j++) {
                MerchantCustomerDto merchantDto = new MerchantCustomerDto(merchant.getProducts().get(i).getPurchaseDetails().get(j).getPurchase().getCustomer(),
                        amount.add(merchant.getProducts().get(i).getPurchaseDetails().get(j).getSubTotal()));
                merchantDtos.add(merchantDto);
            }
        }
        return merchantDtos;
    }

    private void validateMerchant(String merchantId) {
        if (!merchantRepository.findById(merchantId).isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format(notFoundMessage, merchantId));
        }
    }
}
