package com.github.ageresgit.client.model;

public interface PaymentCard {
    boolean isValidPan();

    boolean isValidPin();

    String getPan();

    String getPin();
}
