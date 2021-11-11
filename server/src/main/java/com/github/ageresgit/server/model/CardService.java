package com.github.ageresgit.server.model;


import com.github.ageresgit.common.Response;

public interface CardService {
    Response getBalance(String pan, String pin);
}
