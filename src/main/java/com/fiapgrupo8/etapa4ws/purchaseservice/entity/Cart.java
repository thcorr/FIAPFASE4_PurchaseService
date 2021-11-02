package com.fiapgrupo8.etapa4ws.purchaseservice.entity;

import com.fiapgrupo8.etapa4ws.purchaseservice.dto.CartDTO;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "TB_CART")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long cartId;

    @Column
    private Date createdDate;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="TB_CART_PRODUCT",
            joinColumns={@JoinColumn(name="cart_id")},
            inverseJoinColumns={@JoinColumn(name="product_id")})
    List<Product> productsInCart;



}
