package com.github.arseeenyyy.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.arseeenyyy.models.request.MessageRequest;
import com.github.arseeenyyy.models.response.MessageResponse;

@RestController
@CrossOrigin
@RequestMapping
public class EchoController {
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/echo")
    public ResponseEntity<MessageResponse> echo(@RequestBody MessageRequest messageRequest) {
        final MessageResponse messageResponse = new MessageResponse();
        messageResponse.setMessage();
        return ResponseEntity.ok(messageResponse);
    }
}
