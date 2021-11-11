package com.github.ageresgit.client.service;

import com.github.ageresgit.client.model.BasicPaymentCard;
import com.github.ageresgit.client.model.PaymentCard;
import com.github.ageresgit.client.model.PaymentCardFactory;
import org.springframework.stereotype.Service;

@Service
public class BasicCardFactory implements PaymentCardFactory {
    @Override
    public PaymentCard paymentCardOf(String pan, String pin) {
        return new BasicPaymentCard(pan, pin);
    }
}
