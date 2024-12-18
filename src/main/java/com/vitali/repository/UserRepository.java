package com.vitali.repository;

import com.vitali.modal.User;
import org.springframework.data.jpa.repository.JpaRepository;


// JpaRepository interface that provides generic CRUD
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
