package com.mandiri.tokonyadia.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "m_product")
public class Product {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    private String name;
    private String description;
    private String image;
    private Integer stock;
    private BigDecimal price;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    //    @ManyToOne(targetEntity = Merchant.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "merchant_id")
//    @JsonIgnoreProperties({"products"})
//    private Merchant merchant;
//
//    public Merchant getMerchant() {
//        return merchant;
//    }
//
//    public void setMerchant(Merchant merchant) {
//        this.merchant = merchant;
//    }
    //    @JsonIgnoreProperties({"products"})
//    private Merchant merchant;

//    private  String merchantId;

//    public String getMerchantId() {
//        return merchantId;
//    }
//
//    public void setMerchantId(String merchantId) {
//        this.merchantId = merchantId;
//    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
