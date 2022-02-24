package ru.gb.clientapi.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import ru.gb.api.events.OrderEvent;
import ru.gb.clientapi.config.JmsConfig;
import ru.gb.clientapi.sender.MailService;

public class OrderListener {

    private MailService mailService;

    @JmsListener(destination = JmsConfig.ORDER_CHANGED)
    public void listen(@Payload OrderEvent orderEvent){
        System.out.println(orderEvent);
        mailService.sendMail("redoreole@gmail.com",
                "Order change", orderEvent.getOrderDto().toString());
    }
}
