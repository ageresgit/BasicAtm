package com.github.ageresgit.client.format;

import com.github.ageresgit.client.exception.RemoteServiceException;
import com.github.ageresgit.common.Currency;
import com.github.ageresgit.common.Response;
import com.github.ageresgit.common.ResponseType;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Optional;

public class BalanceFormat {
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
        ResponseType type = Optional.ofNullable(response).map(Response::getResponseType).orElseThrow(() -> new RemoteServiceException("Отсутствует ответ сервера!"));
        Currency currency = response.getCurrency();
        BigDecimal amount = response.getAmount();

        if (type.isBalanceRequired()) {
            if (Objects.isNull(currency)) {
                throw new RemoteServiceException("Полученный баланс карты не содержит валюту");
            }
            if (Objects.isNull(amount)) {
                throw new RemoteServiceException("Полученный баланс карты не содержит сумму");
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
