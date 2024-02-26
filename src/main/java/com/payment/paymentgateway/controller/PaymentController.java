package com.payment.paymentgateway.controller;

import com.payment.paymentgateway.dto.InitiatePaymentRequestDto;
import com.payment.paymentgateway.service.PaymentService;
import com.stripe.exception.StripeException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService){
        this.paymentService =paymentService;
    }




    @PostMapping("/")
    public String initiatePayment(@RequestBody InitiatePaymentRequestDto request) throws StripeException {
        return paymentService.initiatepayment(request.getOrderId(), request.getEmail(), request.getPhoneNumber(), request.getAmount());
    }


}
