package com.vitali.service;

import com.vitali.domain.VerificationType;
import com.vitali.modal.User;
import com.vitali.modal.VerificationCode;

public interface VerificationCodeService {
    VerificationCode sendVerificationCode(User user, VerificationType VerificationType);
    VerificationCode getVerificationCodeById(Long id) throws Exception;

    VerificationCode getVerificationCodeByUser(Long userId);



    void deleteVerificationCodeById(VerificationCode verificationCode);

}
