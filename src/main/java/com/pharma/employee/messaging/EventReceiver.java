package com.pharma.employee.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class EventReceiver {

    private final Logger log = LoggerFactory.getLogger(EventReceiver.class);

    @RabbitListener(queues = "queue-create-appointment")
    public void handleCreateAppointment(Message message) {
        System.out.println("received the message!");
        log.info("Received event in service Appointments: {}", message);
        // Convert to object.
        // Do with it whatever you please.
    }

    @RabbitListener(queues = "queue-update-appointment")
    public void handleUpdateAppointment(Message message) {
        System.out.println("received the message!");
        log.info("Received event in service Appointments: {}", message);
        // Convert to object.
        // Do with it whatever you please.
    }
}

