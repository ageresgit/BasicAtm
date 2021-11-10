package com.github.ageresgit.client.model;

public interface PaymentCardFactory {
    PaymentCard paymentCardOf(String pan, String pin);
}
