package com.github.ageresgit.common;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class Balance {
    Currency currency;
    BigDecimal amount;
}
