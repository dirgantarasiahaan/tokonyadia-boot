package com.mandiri.tokonyadia.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "t_purchase")
public class Purchase {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    private Date purchaseDate;

    @ManyToOne()
    @JoinColumn(name = "customer_id")
    private Customer customer;

//    @OneToMany(mappedBy = "purchase", cascade = CascadeType.PERSIST)
////    @JoinColumn(name = "purchase_id")
//    private List<PurchaseDetail> purchaseDetails = new ArrayList<>();

    @OneToMany(mappedBy = "purchase", cascade = CascadeType.PERSIST)
    @JsonIgnoreProperties("purchase")
    private List<PurchaseDetail> purchaseDetails = new ArrayList<>();


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<PurchaseDetail> getPurchaseDetails() {
        return purchaseDetails;
    }

    public void setPurchaseDetails(List<PurchaseDetail> purchaseDetails) {
        this.purchaseDetails = purchaseDetails;
    }
}
