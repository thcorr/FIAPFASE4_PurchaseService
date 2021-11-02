package com.fiapgrupo8.etapa4ws.purchaseservice.connections;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class RabbitMQConnection {
    private static final String EXCHANGE_NAME = "amq.direct";
    private static final String PURCHASE_NOTIFICATION_QUEUE = "PURCHASE_NOTIFICATION_QUEUE";

    private AmqpAdmin amqpAdmin;

    public RabbitMQConnection(AmqpAdmin amqpAdmin){
        this.amqpAdmin = amqpAdmin;
    }

    private Queue queue(String queueName){
        return new Queue(queueName, true, false, false);
    }

    private DirectExchange directExchange(){
        return new DirectExchange(EXCHANGE_NAME);
    }

    private Binding binding(Queue queue, DirectExchange directExchange){
        return new Binding(queue.getName(), Binding.DestinationType.QUEUE, directExchange.getName(), queue.getName(), null );
    }

    @PostConstruct
    private void configureQueue(){
        Queue purchaseNotificationQueue = this.queue(PURCHASE_NOTIFICATION_QUEUE);
        DirectExchange directExchange = this.directExchange();
        Binding bindingPurchaseNotification = this.binding(purchaseNotificationQueue, directExchange);

        this.amqpAdmin.declareQueue(purchaseNotificationQueue);
        this.amqpAdmin.declareExchange(directExchange);
        this.amqpAdmin.declareBinding(bindingPurchaseNotification);


    }
}
