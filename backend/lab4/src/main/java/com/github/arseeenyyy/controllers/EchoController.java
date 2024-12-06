package com.github.arseeenyyy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.arseeenyyy.models.entities.MessageEntity;
import com.github.arseeenyyy.models.request.MessageRequest;
import com.github.arseeenyyy.models.response.MessageResponse;
import com.github.arseeenyyy.repositories.MessageRepository;

@RestController
@CrossOrigin
@RequestMapping
public class EchoController {
    @Autowired 
    private MessageRepository repository;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/echo")
    public ResponseEntity<MessageResponse> echo(@RequestBody MessageRequest messageRequest) {
        MessageEntity entity = new MessageEntity();
        entity.setMessage("bibaboba");
        repository.save(entity);
        final MessageResponse messageResponse = new MessageResponse();
        messageResponse.setMessage("aaasfasfasf");
        return ResponseEntity.ok(messageResponse);
    }
}
