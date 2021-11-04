package com.github.ageresgit.client.model;

import lombok.Value;

import java.util.regex.Pattern;

@Value
public class BasicPaymentCard implements PaymentCard {
    private String panNumber;
    private String pinCode;

    @Override
    public boolean isValidPan() {
        return (panNumber != null) && (Pattern.compile("^[0-9]{16}$").matcher(panNumber).matches());
    }

    @Override
    public boolean isValidPin() {
        return (pinCode != null) && (Pattern.compile("^[0-9]{4}$").matcher(pinCode).matches());
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
