package com.mandiri.tokonyadia.dto;

import java.math.BigDecimal;

public class PurchaseDto {

    private String emailTo;
    private String customerName;
    private BigDecimal amount;

    public PurchaseDto() {
    }

    public PurchaseDto(String emailTo, String customerName, BigDecimal amount) {
        this.emailTo = emailTo;
        this.customerName = customerName;
        this.amount = amount;
    }

    public String getEmailTo() {
        return emailTo;
    }

    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo;
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
