package com.github.arseeenyyy.models.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name = "message_test")
public class MessageEntity implements Serializable {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "message", nullable = false)
    private String message;

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public long getId() {
        return id;
    }
}
