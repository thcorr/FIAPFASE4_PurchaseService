package com.fiapgrupo8.etapa4ws.purchaseservice.service;

import com.fiapgrupo8.etapa4ws.purchaseservice.dto.PurchaseCreateDTO;
import com.fiapgrupo8.etapa4ws.purchaseservice.dto.PurchaseDTO;


import java.util.List;
import java.util.UUID;

public interface PurchaseService {

    List<PurchaseDTO> getAllPurchases();
    PurchaseDTO getPurchaseById(Long id);
    PurchaseDTO createPurchase(PurchaseCreateDTO purchase);
    PurchaseDTO updatePurchaseById(PurchaseDTO purchase, Long id);
    PurchaseDTO cancelPurchaseById(Long id);
    PurchaseDTO confirmPaymentById(Long id);
    PurchaseDTO confirmShippedById(Long id);
    PurchaseDTO confirmDeliveryById(Long id);

}
