package com.mandiri.tokonyadia.service;

import com.mandiri.tokonyadia.entity.Customer;
import com.mandiri.tokonyadia.entity.Product;
import com.mandiri.tokonyadia.entity.Purchase;
import com.mandiri.tokonyadia.entity.PurchaseDetail;
import com.mandiri.tokonyadia.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Service
public class PurchaseServiceImpl implements PurchaseService{

    public static String notFoundMessage = "Purchase with ID : %s Not Found";

    @Autowired
    PurchaseRepository purchaseRepository;

    @Autowired
    CustomerService customerService;

    @Autowired
    ProductService productService;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Purchase findPurchaseById(String purchaseId) {
        validatePurchase(purchaseId);
        return purchaseRepository.findById(purchaseId).get();
    }

    @Override
    public Page<Purchase> findAllPurchase(Pageable pageable) {
        return purchaseRepository.findAll(pageable);
    }

    @Override
    public Purchase createNewPurchase(Purchase purchase, String customerId) {
        purchase.setPurchaseDate(new Timestamp(new Date().getTime()));
        Purchase purchaseDetail =  purchaseRepository.save(purchase);
        System.out.println("ID : " + purchaseDetail.getId());
        Customer customer = customerService.findCustomertById(customerId);
        purchase.setCustomer(customer);
        BigDecimal amount = updateStockAndGetAmount(purchaseDetail);

        String url = "http://localhost:8081/debit";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("phoneNumber", customer.getPhoneNumber())
                .queryParam("amount", amount);

        restTemplate.exchange(builder.toUriString(), HttpMethod.POST, null, String.class);

        return purchaseDetail;
    }

    private void validatePurchase(String purchaseId) {
        if (!purchaseRepository.findById(purchaseId).isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format(notFoundMessage, purchaseId));
        }
    }

    private BigDecimal updateStockAndGetAmount(Purchase purchaseDetail) {
        BigDecimal amount = new BigDecimal(0.0);
        Product product = new Product();
        Product updateProduct = new Product();

        for (PurchaseDetail purchaseDetails: purchaseDetail.getPurchaseDetails()) {
            product = productService.findProductById(purchaseDetails.getProduct().getId());

            if (purchaseDetails.getQuantity() > product.getStock()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Quantity Order > stock");
            }
            purchaseDetails.setPurchase(purchaseDetail);
            purchaseDetails.setProduct(product);
            product.setStock(product.getStock() - purchaseDetails.getQuantity());
            product.setUpdatedAt(new Timestamp(new Date().getTime()));
            purchaseDetails.setSub_total(BigDecimal.valueOf(purchaseDetails.getQuantity()).multiply(product.getPrice()));
            updateProduct = productService.updateProduct(product);
            amount = amount.add(product.getPrice().multiply(new BigDecimal(purchaseDetails.getQuantity())));
        }
        return amount;
    }
}
