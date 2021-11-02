package com.fiapgrupo8.etapa4ws.purchaseservice.repository;

import com.fiapgrupo8.etapa4ws.purchaseservice.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
