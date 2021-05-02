package com.mandiri.tokonyadia.dto;

import com.mandiri.tokonyadia.entity.Customer;

import java.math.BigDecimal;
import java.util.*;

public class MerchantCustomerDto {

    private Customer customers;
    private BigDecimal totalPayment;

    public MerchantCustomerDto() {
    }

    public MerchantCustomerDto(Customer customers, BigDecimal amount) {
        this.customers = customers;
        this.totalPayment = amount;
    }

    public Customer getCustomers() {
        return customers;
    }

    public void setCustomers(Customer customers) {
        this.customers = customers;
    }

    public BigDecimal getAmount() {
        return totalPayment;
    }

    public void setAmount(BigDecimal amount) {
        this.totalPayment = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MerchantCustomerDto that = (MerchantCustomerDto) o;
        return Objects.equals(customers, that.customers) && Objects.equals(totalPayment, that.totalPayment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customers, totalPayment);
    }
}
