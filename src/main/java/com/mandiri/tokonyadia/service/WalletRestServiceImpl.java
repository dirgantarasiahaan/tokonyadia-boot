package com.mandiri.tokonyadia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;

@Service
public class WalletRestServiceImpl implements WalletRestService{

    @Autowired
    RestTemplate restTemplate;

    @Override
    public String debitWallet(String phoneNumber, BigDecimal amount) {

        String url = "http://localhost:8081/debit";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("phoneNumber", phoneNumber)
                .queryParam("amount", amount);

        ResponseEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, null, String.class);
        return response.getBody();
    }
}
