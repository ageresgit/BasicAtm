package com.github.ageresgit.client.model;

import lombok.NonNull;
import lombok.Value;

import java.util.regex.Pattern;

@Value
public class BasicPaymentCard implements PaymentCard {
    @NonNull
    String panNumber;
    @NonNull
    String pinCode;

    @Override
    public boolean isValidPan() {
        return Pattern.compile("^[0-9]{16}$").matcher(panNumber).matches();
    }

    @Override
    public boolean isValidPin() {
        return Pattern.compile("^[0-9]{4}$").matcher(pinCode).matches();
    }

    @Override
    public String getPan() {
        return panNumber;
    }

    @Override
    public String getPin() {
        return pinCode;
    }
}
