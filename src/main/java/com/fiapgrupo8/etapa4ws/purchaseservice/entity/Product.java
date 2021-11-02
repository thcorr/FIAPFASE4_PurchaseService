package com.fiapgrupo8.etapa4ws.purchaseservice.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TB_PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
}
