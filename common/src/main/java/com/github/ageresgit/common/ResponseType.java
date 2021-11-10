package com.github.ageresgit.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResponseType {
    SUCCESS("Баланс вашей карты: "),
    UNKNOWN_CARD("Данная карта не обслуживается!"),
    INCORRECT_PIN("Неправильный ПИН-код!"),
    ;
    private String description;
}
