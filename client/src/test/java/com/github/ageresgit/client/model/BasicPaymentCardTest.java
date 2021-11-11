package com.github.ageresgit.client.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BasicPaymentCardTest {
    BasicPaymentCard goodCard;
    BasicPaymentCard badCardWrongLength;
    BasicPaymentCard badCardWrongSymbols;

    @BeforeEach
    void setup() {
        goodCard = new BasicPaymentCard("2340234023402340", "1234");
        badCardWrongLength = new BasicPaymentCard("12", "123456789");
        badCardWrongSymbols = new BasicPaymentCard("ABCDABCDABCDABCD", "234!");
    }

    @Test
    void pinOkTest() {
        Assertions.assertTrue(goodCard.isValidPin());
    }

    @Test
    void panOkTest() {
        Assertions.assertTrue(goodCard.isValidPan());
    }

    @Test
    void panWrongLengthTest() {
        Assertions.assertFalse(badCardWrongLength.isValidPan());
    }

    @Test
    void pinWrongLengthTest() {
        Assertions.assertFalse(badCardWrongLength.isValidPin());
    }

    @Test
    void panWrongSymbolTest() {
        Assertions.assertFalse(badCardWrongLength.isValidPan());
    }

    @Test
    void pinWrongSymbolTest() {
        Assertions.assertFalse(badCardWrongLength.isValidPin());
    }
}
