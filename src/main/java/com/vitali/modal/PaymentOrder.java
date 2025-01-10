package com.vitali.modal;

import com.vitali.domain.PaymentMethod;
import com.vitali.domain.PaymentOrderStatus;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class PaymentOrder {

    public PaymentOrderStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentOrderStatus status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long amount;

    private PaymentOrderStatus status;

    private PaymentMethod paymentMethod;
    @ManyToOne
    private User user;

}
