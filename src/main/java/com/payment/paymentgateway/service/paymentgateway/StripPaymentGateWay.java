package com.payment.paymentgateway.service.paymentgateway;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentLink;
import com.stripe.model.Price;
import com.stripe.param.PaymentLinkCreateParams;
import com.stripe.param.PriceCreateParams;
import com.stripe.param.TopupListParams;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StripPaymentGateWay implements PaymentGateWay{

    @Override
    public String generatePaymentLink(String orderId, String email, String phoneNumber, Long amount) throws StripeException {


        Stripe.apiKey = "sk_test_51OFgEvSCoASgnteTRsQreuyIE6PotiZmCW7fjmgWeyqc5DvKoTSuk4j4Y8x4QPKXYJGrTbbxBGB1ShNU5gcSMT6m00iNZrbjsY";



        PriceCreateParams params =
                PriceCreateParams.builder()
                        .setCurrency("INR")
                        .setUnitAmount(1000L)
                        .setProductData(
                                PriceCreateParams.ProductData.builder().setName("Boiler").build()
                        )
                        .build();

        Price price = Price.create(params);


        PaymentLinkCreateParams params1 =
                PaymentLinkCreateParams.builder()
                        .addLineItem(
                                PaymentLinkCreateParams.LineItem.builder()
                                        .setPrice(price.getId())
                                        .setQuantity(2L)
                                        .build()
                        )
                        .build();

        PaymentLink paymentLink = PaymentLink.create(params1);
        return paymentLink.toString();
    }
}

