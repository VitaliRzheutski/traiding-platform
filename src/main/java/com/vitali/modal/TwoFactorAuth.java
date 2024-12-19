package com.vitali.modal;

import com.vitali.domain.VerificationType;
import lombok.Data;

@Data
public class TwoFactorAuth {
    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public VerificationType getSendTo() {
        return sendTo;
    }

    public void setSendTo(VerificationType sendTo) {
        this.sendTo = sendTo;
    }

    private boolean isEnabled;
    private VerificationType sendTo;
}
