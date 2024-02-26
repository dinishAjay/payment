package com.payment.paymentgateway.service.paymentgateway;

import com.stripe.exception.StripeException;

public interface PaymentGateWay {
    String generatePaymentLink(String orderId, String email, String phoneNumber, Long amount) throws StripeException;
}
