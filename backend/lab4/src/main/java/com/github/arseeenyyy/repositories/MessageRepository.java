package com.github.arseeenyyy.repositories;

import org.springframework.data.repository.CrudRepository;

import com.github.arseeenyyy.models.entities.MessageEntity;

public interface MessageRepository extends CrudRepository<MessageEntity, Long> {
    
}
