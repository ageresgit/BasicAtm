package com.github.ageresgit.client.service;

import com.github.ageresgit.client.model.BasicPaymentCard;
import com.github.ageresgit.client.model.PaymentCard;
import com.github.ageresgit.client.model.PaymentCardGenerator;
import org.springframework.stereotype.Service;

@Service
public class BasicCardGenerator implements PaymentCardGenerator {
    @Override
    public PaymentCard paymentCardOf(String pan, String pin) {
        return new BasicPaymentCard(pan, pin);
    }
}
