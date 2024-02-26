package com.payment.paymentgateway.service;

import com.payment.paymentgateway.service.paymentgateway.PaymentGateWay;
import com.stripe.exception.StripeException;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private  PaymentGateWayChooseStrategy paymentGateWayChooseStrategy;
    public PaymentService(PaymentGateWayChooseStrategy paymentGateWayChooseStrategy){
        this.paymentGateWayChooseStrategy =paymentGateWayChooseStrategy;
    }

    public String initiatepayment(String orderId, String email, String phoneNumber, Long amount) throws StripeException {
       PaymentGateWay payment =paymentGateWayChooseStrategy.bestPaymentGateWay();
       return payment.generatePaymentLink( orderId, email,  phoneNumber, amount);
    }
}
