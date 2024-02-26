package com.payment.paymentgateway.service;

import com.payment.paymentgateway.service.paymentgateway.PaymentGateWay;
import com.payment.paymentgateway.service.paymentgateway.RazopayPaymentGateWay;
import com.payment.paymentgateway.service.paymentgateway.StripPaymentGateWay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentGateWayChooseStrategy {


    private RazopayPaymentGateWay razopayPaymentGateWay;


    private StripPaymentGateWay stripPaymentGateWay;


    public PaymentGateWayChooseStrategy(RazopayPaymentGateWay razopayPaymentGateWay,
                                        StripPaymentGateWay stripPaymentGateWay){
        this.razopayPaymentGateWay =razopayPaymentGateWay;
        this.stripPaymentGateWay =stripPaymentGateWay;
    }

    public PaymentGateWay bestPaymentGateWay(){
        return stripPaymentGateWay;
    }



}
