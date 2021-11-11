package com.github.ageresgit.client.format;

import com.github.ageresgit.client.exception.RemoteServiceException;
import com.github.ageresgit.common.Currency;
import com.github.ageresgit.common.Response;
import com.github.ageresgit.common.ResponseType;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Optional;

public class BalanceFormat {
    public static final String NO_RESPONSE_MESSAGE = "Отсутствует ответ сервера!";
    public static final String NO_CURRENCY_MESSAGE = "Полученный баланс карты не содержит валюту!";
    public static final String NO_AMOUNT_MESSAGE = "Полученный баланс карты не содержит сумму!";

    private ResponseType responseType;
    private Currency currency;
    private BigDecimal amount;

    private BalanceFormat() {
    }

    private BalanceFormat(ResponseType responseType, Currency currency, BigDecimal amount) {
        this.responseType = responseType;
        this.currency = currency;
        this.amount = amount;
    }

    public static BalanceFormat of(Response response) {
        ResponseType type = Optional.ofNullable(response).map(Response::getResponseType).orElseThrow(() -> new RemoteServiceException(NO_RESPONSE_MESSAGE));
        Currency currency = response.getCurrency();
        BigDecimal amount = response.getAmount();

        if (type.isBalanceRequired()) {
            if (Objects.isNull(currency)) {
                throw new RemoteServiceException(NO_CURRENCY_MESSAGE);
            }
            if (Objects.isNull(amount)) {
                throw new RemoteServiceException(NO_AMOUNT_MESSAGE);
            }
        }

        return new BalanceFormat(type, currency, amount);
    }

    public static String describeServiceError() {
        return ResponseType.SERVICE_UNAVAILABLE.toString();
    }

    public String describe() {
        if (responseType.isBalanceRequired()) {
            return responseType.toString() + amount + " " + currency;
        }
        return responseType.toString();
    }
}
