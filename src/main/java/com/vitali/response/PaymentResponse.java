package com.vitali.response;

import lombok.Data;

@Data
public class PaymentResponse {
    public String getPayment_url() {
        return payment_url;
    }

    public void setPayment_url(String payment_url) {
        this.payment_url = payment_url;
    }

    private String payment_url;
}
