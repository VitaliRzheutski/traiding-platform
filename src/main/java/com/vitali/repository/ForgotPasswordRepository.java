package com.vitali.repository;

import com.vitali.modal.ForgotPasswordToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForgotPasswordRepository extends JpaRepository<ForgotPasswordToken, String> { //String was boolean before
    public ForgotPasswordToken findByUserId(Long userId);
}
