package com.vitali.repository;

import com.vitali.modal.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


// JpaRepository interface that provides generic CRUD
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    // Add the findById method if not already present (it should be available by default with JpaRepository)
    Optional<User> findById(Long id);
}
