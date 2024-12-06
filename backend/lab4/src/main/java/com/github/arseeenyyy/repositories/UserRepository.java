package com.github.arseeenyyy.repositories;

import org.springframework.data.repository.CrudRepository;

import com.github.arseeenyyy.models.entities.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    
}
