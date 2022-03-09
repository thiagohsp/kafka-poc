package br.com.local.kafkaproducer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.local.kafkaproducer.dto.SendMessageData;
import br.com.local.kafkaproducer.services.EventService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MessageController {

  @Autowired
  private EventService service;

  @PostMapping("/send")
  public ResponseEntity<String> send(@RequestBody SendMessageData message) {
    System.out.println(message);
    this.service.execute("post-send-messages", message);
    return ResponseEntity.ok("Mensagem enviada!");
  }
}
