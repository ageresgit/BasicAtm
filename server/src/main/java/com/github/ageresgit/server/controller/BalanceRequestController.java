package com.github.ageresgit.server.controller;

import com.github.ageresgit.common.Request;
import com.github.ageresgit.server.service.CardService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Slf4j
@RestController
@AllArgsConstructor
public class BalanceRequestController {

    private final CardService cardService;

    @GetMapping("/hello/{clientName}")
    public String getHelloClient(@PathVariable("clientName") String clientName) {
        return "Hello, dear " + clientName + "!";
    }

    @GetMapping("/hello")
    public String getHello() {
        return "Yo, man!";
    }

    @PostMapping("/balancerequest")
    public String balanceRequestProcess(@RequestBody Request request) {
        log.info("Server got request = " + request);
        return cardService.getBalance(request.getCardPan(), request.getCardPin());
    }
}
