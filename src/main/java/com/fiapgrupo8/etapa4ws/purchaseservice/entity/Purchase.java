package com.fiapgrupo8.etapa4ws.purchaseservice.entity;

import com.fiapgrupo8.etapa4ws.purchaseservice.dto.PurchaseCreateDTO;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "TB_PRUCHASE")
public class Purchase {

    public Purchase(){}

    public Purchase(PurchaseCreateDTO purchaseCreateDTO){
        super();
        this.cartId = purchaseCreateDTO.getCartId();
        this.clientCode = purchaseCreateDTO.getClientCode();
        this.clientName = purchaseCreateDTO.getClientName();
        this.createdDate = purchaseCreateDTO.getCreatedDate();
        this.purchaseStatus = "NEW";
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long purchaseId;

    @Column
    private LocalDateTime createdDate;

    @Column
    private Long cartId;

    @Column
    private Long clientCode;

    @Column
    private String clientName;

    @Column
    private String purchaseStatus;

}
