package com.vitali.service;

import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;
import com.vitali.domain.PaymentMethod;
import com.vitali.modal.PaymentOrder;
import com.vitali.modal.User;
import com.vitali.response.PaymentResponse;

public interface PaymentService {

    PaymentOrder createOrder(User user, Long amount, PaymentMethod paymentMethod);
    PaymentOrder getPaymentOrderById(Long id) throws Throwable;
    Boolean ProceedPaymentOrder(PaymentOrder paymentOrder, String paymentId) throws RazorpayException;

    PaymentResponse createRazorpayPaymentLink(User user, Long amount,Long orderId);
    PaymentResponse stripePaymentLink(User user, Long amount, Long orderId) throws StripeException;


}
