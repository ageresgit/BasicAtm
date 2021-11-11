package com.github.ageresgit.server.controller;

import com.github.ageresgit.common.Request;
import com.github.ageresgit.common.Response;
import com.github.ageresgit.server.model.CardService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@AllArgsConstructor
public class BalanceRequestController {

    private final CardService cardService;

    @GetMapping("/hello/{clientName}")
    public String getHelloClient(@PathVariable("clientName") String clientName) {
        return "Hello, dear " + clientName + "!";
    }

    @PostMapping("/balancerequest")
    public Response balanceRequestProcess(@RequestBody Request request) {
        log.info("Получен запрос: " + request);
        Response response = cardService.getBalance(request.getCardPan(), request.getCardPin());
        log.info("Сформирован ответ: " + response);
        return response;
    }
}
