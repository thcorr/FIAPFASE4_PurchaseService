package com.fiapgrupo8.etapa4ws.purchaseservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties
@Data
public class CartDTO {

    Long id;
    List<ProductDTO> productsInCart;

}
