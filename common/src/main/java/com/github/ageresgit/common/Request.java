package com.github.ageresgit.common;

import lombok.Value;

@Value
public class Request {
    RequestType requestType;
    String cardPan;
    String cardPin;
    long callerId;
}
