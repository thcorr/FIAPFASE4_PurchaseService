package com.fiapgrupo8.etapa4ws.purchaseservice.controller;

import com.fiapgrupo8.etapa4ws.purchaseservice.dto.PurchaseCreateDTO;
import com.fiapgrupo8.etapa4ws.purchaseservice.dto.PurchaseDTO;
import com.fiapgrupo8.etapa4ws.purchaseservice.service.PurchaseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    private PurchaseService purchaseService;

    public PurchaseController (PurchaseService purchaseService){
        this.purchaseService = purchaseService;
    }

    @GetMapping
    public List<PurchaseDTO> getAllPurchases(){return purchaseService.getAllPurchases();}

    @GetMapping("/{id}")
    public PurchaseDTO getPurchaseById(@PathVariable(name = "id") Long id){
        return purchaseService.getPurchaseById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PurchaseDTO createPurchase(@RequestBody PurchaseCreateDTO newPurchase) {
        return purchaseService.createPurchase(newPurchase);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PurchaseDTO updatePurchaseById(@RequestBody PurchaseDTO purchaseUpdated,
                                  @PathVariable Long id) {
        return purchaseService.updatePurchaseById(purchaseUpdated, id);
    }

    @PutMapping("/cancel/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PurchaseDTO cancelPurchaseById(@PathVariable(name = "id") Long id){
        return purchaseService.cancelPurchaseById(id);
    }

    @PutMapping("/Paid/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PurchaseDTO confirmPaidPurchaseById(@PathVariable(name = "id") Long id){
        return purchaseService.confirmPaymentById(id);
    }

    @PutMapping("/Shipped/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PurchaseDTO confirmShippedPurchaseById(@PathVariable(name = "id") Long id){
        return purchaseService.confirmShippedById(id);
    }

    @PutMapping("/Delivered/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PurchaseDTO confirmDeliveredPurchaseById(@PathVariable(name = "id") Long id){
        return purchaseService.confirmDeliveryById(id);
    }
}
