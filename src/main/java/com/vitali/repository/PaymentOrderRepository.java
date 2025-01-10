package com.vitali.repository;

import com.vitali.modal.PaymentOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.parameters.P;

public interface PaymentOrderRepository extends JpaRepository<PaymentOrder, Long> {

}
