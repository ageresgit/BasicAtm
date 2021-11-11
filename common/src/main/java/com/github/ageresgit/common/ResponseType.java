package com.github.ageresgit.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResponseType {
    SUCCESS("Доступный остаток средств: ", true),
    UNKNOWN_CARD("Данная карта не обслуживается!", false),
    INCORRECT_PIN("Неправильный ПИН-код!", false),
    SERVICE_UNAVAILABLE("Сервис временно недоступен!", false),
    INVALID_PAN("Некорректный формат номера карты!", false),
    INVALID_PIN_CODE("Некорректный формат ПИН-кода!", false);
    private String description;
    private boolean balanceRequired;

    @Override
    public String toString() {
        return description;
    }
}
