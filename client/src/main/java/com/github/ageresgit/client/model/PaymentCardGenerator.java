package com.github.ageresgit.client.model;

public interface PaymentCardGenerator {
    PaymentCard paymentCardOf(String pan, String pin);
}
