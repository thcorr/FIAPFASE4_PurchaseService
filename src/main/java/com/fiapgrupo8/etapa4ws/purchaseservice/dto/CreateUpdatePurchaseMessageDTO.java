package com.fiapgrupo8.etapa4ws.purchaseservice.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class CreateUpdatePurchaseMessageDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    public CreateUpdatePurchaseMessageDTO(){}
    public CreateUpdatePurchaseMessageDTO(PurchaseDTO purchase, String type){
        this.purchaseDTO = purchase;
        this.type = type;
        this.timestamp = LocalDateTime.now();
    }

    public PurchaseDTO purchaseDTO;
    public LocalDateTime timestamp;
    public String type;
}
