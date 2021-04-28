package com.mandiri.tokonyadia.service;

import java.math.BigDecimal;

public interface WalletRestService {

    public String debitWallet(String phoneNumber, BigDecimal amount);
}
