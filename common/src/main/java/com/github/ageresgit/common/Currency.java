package com.github.ageresgit.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Currency {
    RUB("RUB"),
    EUR("EUR"),
    USD("USD");

    private String currencyName;

    @Override
    public String toString() {
        return currencyName;
    }
}
