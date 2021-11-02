package com.fiapgrupo8.etapa4ws.purchaseservice.dto;

import com.fiapgrupo8.etapa4ws.purchaseservice.entity.Purchase;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class PurchaseCreateDTO {

    public PurchaseCreateDTO(){};

    public PurchaseCreateDTO(Purchase purchase){
        super();
        this.createdDate = purchase.getCreatedDate();
        this.cartId = purchase.getCartId();
        this.clientCode = purchase.getClientCode();
        this.clientName = purchase.getClientName();
    }


    private LocalDateTime createdDate;
    private Long cartId;
    private Long clientCode;
    private String clientName;
}
