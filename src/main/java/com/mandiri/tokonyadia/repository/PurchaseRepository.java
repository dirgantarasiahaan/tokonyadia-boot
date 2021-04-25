package com.mandiri.tokonyadia.repository;

import com.mandiri.tokonyadia.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, String> {
}
