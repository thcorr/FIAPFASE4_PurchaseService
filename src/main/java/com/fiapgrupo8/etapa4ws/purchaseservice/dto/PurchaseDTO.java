package com.fiapgrupo8.etapa4ws.purchaseservice.dto;

import com.fiapgrupo8.etapa4ws.purchaseservice.entity.Purchase;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class PurchaseDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    public PurchaseDTO(){}

    public PurchaseDTO(Purchase purchase){
        super();
        this.purchaseId = purchase.getPurchaseId();
        this.createdDate = purchase.getCreatedDate();
        this.cartId = purchase.getCartId();
        this.clientCode = purchase.getClientCode();
        this.clientName = purchase.getClientName();
        this.purchaseStatus = purchase.getPurchaseStatus();
    }

    private Long purchaseId;
    private LocalDateTime createdDate;
    private Long cartId;
    private Long clientCode;
    private String clientName;
    private String purchaseStatus;

}
