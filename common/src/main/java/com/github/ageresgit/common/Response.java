package com.github.ageresgit.common;

import lombok.*;

import java.math.BigDecimal;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Response {
    private ResponseType responseType;
    private Currency currency;
    private BigDecimal amount;

}
