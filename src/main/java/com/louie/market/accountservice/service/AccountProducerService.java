package com.louie.market.accountservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class AccountProducerService {

  private final KafkaTemplate<String, String> kafkaTemplate;
  private final String topic = "account-topic";

  @Autowired
  public AccountProducerService(KafkaTemplate<String, String> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void sendMessage(String message) {
    kafkaTemplate.send(topic, message);
  }
}