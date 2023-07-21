package com.rloth.kafkaconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {
    private final MessageRepository messageRepository;

    @Autowired
    public KafkaListeners(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @KafkaListener(topics = "rloth", groupId = "groupId")
    void listener(String data) {
        System.out.println("Listener received: " + data + " 🥳");

        Message message = new Message();
        message.setContent(data);
        message.setTopic("rloth");
        messageRepository.save(message);
    }
}
