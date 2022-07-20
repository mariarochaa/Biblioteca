package com.bibliotecacras.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bibliotecacras.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
}
 