package br.com.local.kafkaproducer.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EventService {

  @Autowired
  private KafkaTemplate<Object, Object> template;

  public <T> void execute(String topic, T message) {
    template.send(topic, LocalDateTime.now().toString(), message);
  }
}
