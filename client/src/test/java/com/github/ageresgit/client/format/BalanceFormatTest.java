package com.github.ageresgit.client.format;

import com.github.ageresgit.client.exception.RemoteServiceException;
import com.github.ageresgit.common.Currency;
import com.github.ageresgit.common.Response;
import com.github.ageresgit.common.ResponseType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class BalanceFormatTest {
    @Test
    void responseTypeCheckTest() {
        Response response = Response.builder().currency(Currency.RUB).amount(BigDecimal.TEN).build();
        Exception thrown = Assertions.assertThrows(RemoteServiceException.class, (() -> BalanceFormat.of(response)));
        Assertions.assertEquals(thrown.getMessage(), BalanceFormat.NO_RESPONSE_MESSAGE);
    }

    @Test
    void amountCheckTest() {
        Response response = Response.builder().responseType(ResponseType.SUCCESS).currency(Currency.EUR).build();
        Exception thrown = Assertions.assertThrows(RemoteServiceException.class, (() -> BalanceFormat.of(response)));
        Assertions.assertEquals(thrown.getMessage(), BalanceFormat.NO_AMOUNT_MESSAGE);
    }

    @Test
    void currencyCheckTest() {
        Response response = Response.builder().responseType(ResponseType.SUCCESS).amount(BigDecimal.TEN).build();
        Exception thrown = Assertions.assertThrows(RemoteServiceException.class, (() -> BalanceFormat.of(response)));
        Assertions.assertEquals(thrown.getMessage(), BalanceFormat.NO_CURRENCY_MESSAGE);
    }
}
