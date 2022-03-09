package br.com.local.kafkaconsumer.services;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ListenerSendMessagesService {

  @KafkaListener(topics = "post-send-messages", groupId = "ListenerSendMessagesService")
  public void execute(ConsumerRecord<String, String> record) {
    log.info("Key = {}", record.key());
    log.info("Headers = {}", record.headers());
    log.info("Value = {}", record.value());
  }
}
