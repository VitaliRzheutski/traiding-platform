package com.vitali.service;

import com.vitali.domain.VerificationType;
import com.vitali.modal.ForgotPasswordToken;
import com.vitali.modal.User;

public interface ForgotPasswordService {

    ForgotPasswordToken createToken(
            User user,
            String id,
            String otp,
            VerificationType verificationType,
            String sendTo
    );

    ForgotPasswordToken findById(String id);
    ForgotPasswordToken findByUser(Long userId);

    void deleteToken(ForgotPasswordToken token);
}
