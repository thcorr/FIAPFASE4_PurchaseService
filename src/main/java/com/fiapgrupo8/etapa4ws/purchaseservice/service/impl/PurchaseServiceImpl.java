package com.fiapgrupo8.etapa4ws.purchaseservice.service.impl;

import com.fiapgrupo8.etapa4ws.purchaseservice.dto.CreateUpdatePurchaseMessageDTO;
import com.fiapgrupo8.etapa4ws.purchaseservice.dto.PurchaseCreateDTO;
import com.fiapgrupo8.etapa4ws.purchaseservice.dto.PurchaseDTO;
import com.fiapgrupo8.etapa4ws.purchaseservice.entity.Purchase;
import com.fiapgrupo8.etapa4ws.purchaseservice.repository.PurchaseRepository;
import com.fiapgrupo8.etapa4ws.purchaseservice.service.PurchaseService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    PurchaseRepository purchaseRepository;
    RabbitTemplate rabbitTemplate;

    public PurchaseServiceImpl (PurchaseRepository purchaseRepository, RabbitTemplate rabbitTemplate){
        this.purchaseRepository = purchaseRepository;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public List<PurchaseDTO> getAllPurchases() {
        return purchaseRepository.findAll().stream().map(purchase -> new PurchaseDTO(purchase)).collect(Collectors.toList());
    }

    @Override
    public PurchaseDTO getPurchaseById(Long id) {
        Purchase purchase = purchaseRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return new PurchaseDTO(purchase);
    }

    @Override
    public PurchaseDTO createPurchase(PurchaseCreateDTO purchase) {
        Purchase purchaseEntity = new Purchase(purchase);
        Purchase savedPurchaseEntity = purchaseRepository.save(purchaseEntity);
        PurchaseDTO purchaseDTO = new PurchaseDTO(savedPurchaseEntity);
        CreateUpdatePurchaseMessageDTO newMsg = new CreateUpdatePurchaseMessageDTO(purchaseDTO, "create");
        sendMsg(newMsg);
        return purchaseDTO;
    }

    @Override
    public PurchaseDTO updatePurchaseById(PurchaseDTO purchase, Long id) {
        Purchase purchaseInDb = purchaseRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        purchaseInDb.setCartId(purchase.getCartId());
        purchaseInDb.setClientCode(purchase.getClientCode());
        purchaseInDb.setClientName(purchase.getClientName());
        purchaseInDb.setCreatedDate(purchase.getCreatedDate());
        purchaseInDb.setPurchaseStatus(purchase.getPurchaseStatus());

        Purchase savedPurchase = purchaseRepository.save(purchaseInDb);
        PurchaseDTO purchaseDTO = new PurchaseDTO(savedPurchase);

        CreateUpdatePurchaseMessageDTO newMsg = new CreateUpdatePurchaseMessageDTO(purchaseDTO, "update");
        sendMsg(newMsg);

        return purchaseDTO;
    }

    @Override
    public PurchaseDTO cancelPurchaseById(Long id) {
        Purchase purchaseInDb = purchaseRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        purchaseInDb.setPurchaseStatus("CANCELED");
        Purchase savedPuchase = purchaseRepository.save(purchaseInDb);
        PurchaseDTO purchaseDTO = new PurchaseDTO(savedPuchase);

        CreateUpdatePurchaseMessageDTO newMsg = new CreateUpdatePurchaseMessageDTO(purchaseDTO, "cancel");
        sendMsg(newMsg);

        return purchaseDTO;
    }

    @Override
    public PurchaseDTO confirmPaymentById(Long id) {
        Purchase purchaseInDb = purchaseRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        purchaseInDb.setPurchaseStatus("PAID");
        Purchase savedPuchase = purchaseRepository.save(purchaseInDb);
        PurchaseDTO purchaseDTO = new PurchaseDTO(savedPuchase);

        CreateUpdatePurchaseMessageDTO newMsg = new CreateUpdatePurchaseMessageDTO(purchaseDTO, "paid");
        sendMsg(newMsg);

        return purchaseDTO;
    }

    @Override
    public PurchaseDTO confirmShippedById(Long id) {
        Purchase purchaseInDb = purchaseRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        purchaseInDb.setPurchaseStatus("SHIPPED");
        Purchase savedPuchase = purchaseRepository.save(purchaseInDb);
        PurchaseDTO purchaseDTO = new PurchaseDTO(savedPuchase);

        CreateUpdatePurchaseMessageDTO newMsg = new CreateUpdatePurchaseMessageDTO(purchaseDTO, "shipped");
        sendMsg(newMsg);

        return purchaseDTO;
    }


    @Override
    public PurchaseDTO confirmDeliveryById(Long id) {
        Purchase purchaseInDb = purchaseRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        purchaseInDb.setPurchaseStatus("DELIVERED");
        Purchase savedPuchase = purchaseRepository.save(purchaseInDb);
        PurchaseDTO purchaseDTO = new PurchaseDTO(savedPuchase);

        CreateUpdatePurchaseMessageDTO newMsg = new CreateUpdatePurchaseMessageDTO(purchaseDTO, "delivered");
        sendMsg(newMsg);

        return purchaseDTO;
    }


    private void sendMsg(Object message){
        this.rabbitTemplate.convertAndSend("PURCHASE_NOTIFICATION_QUEUE", message);
    }
}
