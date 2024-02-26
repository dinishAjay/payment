package com.payment.paymentgateway.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InitiatePaymentRequestDto {
    private String orderId;
    private String email;
    private String phoneNumber;
    private Long Amount;
}
