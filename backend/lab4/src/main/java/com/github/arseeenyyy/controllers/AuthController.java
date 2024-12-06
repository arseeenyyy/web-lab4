package com.github.arseeenyyy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.github.arseeenyyy.models.entities.UserEntity;
import com.github.arseeenyyy.models.request.UserRequest;
import com.github.arseeenyyy.models.response.MessageResponse;
import com.github.arseeenyyy.repositories.UserRepository;

@RestController
@CrossOrigin
@RequestMapping
public class AuthController {
    @Autowired
    private UserRepository repository;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/register")
    public ResponseEntity<MessageResponse> registerUser(@RequestBody UserRequest userRequest) {
        if (userRequest.getLogin() != null && userRequest.getPassword() != null) {
            UserEntity newUser = new UserEntity();
            newUser.setLogin(userRequest.getLogin()); 
            newUser.setPassword(userRequest.getPassword());
            try {
                repository.save(newUser);
                MessageResponse response = new MessageResponse();
                response.setMessage("bibaboba vse kruto");
                return ResponseEntity.ok(response);
            } catch (Throwable exception) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("cannot register user with login:[%s] and password:[%s]",
                newUser.getLogin(), newUser.getPassword()));
            }
        }
        MessageResponse response = new MessageResponse();
        response.setMessage("vse ploho");
        return ResponseEntity.ok(response);
    }
}
