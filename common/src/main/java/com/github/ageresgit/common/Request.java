package com.github.ageresgit.common;

import lombok.Value;

@Value
public class Request {
    private final RequestType requestType;
    private final String cardPan;
    private final String cardPin;
}
