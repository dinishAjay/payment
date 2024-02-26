package com.payment.paymentgateway.service.paymentgateway;

import org.springframework.stereotype.Service;

@Service
public class RazopayPaymentGateWay implements PaymentGateWay{
    @Override
    public String generatePaymentLink(String orderId, String email, String phoneNumber, Long amount) {
        return null;
    }
}
