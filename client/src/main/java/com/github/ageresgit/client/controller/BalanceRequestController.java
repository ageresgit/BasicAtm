package com.github.ageresgit.client.controller;

import com.github.ageresgit.client.model.AtmService;
import com.github.ageresgit.client.model.PaymentCardFactory;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Log
@RestController
@AllArgsConstructor
public class BalanceRequestController {
    private AtmService atmService;
    private PaymentCardFactory cardFactory;

    @GetMapping("/balance")
    private String balanceRequest(@RequestParam("cardPan") String cardPan,
                                  @RequestParam("cardPin") String cardPin
    ) {
        log.info("Новый запрос: cardPan = " + cardPan + ", cardPin = " + cardPin);
        return atmService.getCardBalance(cardFactory.paymentCardOf(cardPan, cardPin));
    }

}
