package com.github.ageresgit.client.request;

import lombok.Getter;

@Getter
public class Request {

    private final int requestNumber;
    private final String requestId;
    private final String requestBody;

    public Request(int requestNumber, String requestId, String requestBody) {
        this.requestNumber = requestNumber;
        this.requestId = requestId;
        this.requestBody = requestBody;
    }
}
