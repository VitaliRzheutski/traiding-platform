package com.vitali.modal;

import com.vitali.domain.VerificationType;
import lombok.Data;

@Data
public class TwoFactorAuth {
    private boolean isEnabled;
    private VerificationType sendTo;
}
