package com.mandiri.tokonyadia.dto;

import java.math.BigDecimal;

public class PurchaseDto {

    private String emailSender;
    private String customerName;
    private BigDecimal amount;

    public PurchaseDto() {
    }

    public PurchaseDto(String emailSender, String customerName, BigDecimal amount) {
        this.emailSender = emailSender;
        this.customerName = customerName;
        this.amount = amount;
    }

    public String getEmailSender() {
        return emailSender;
    }

    public void setEmailSender(String emailSender) {
        this.emailSender = emailSender;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
