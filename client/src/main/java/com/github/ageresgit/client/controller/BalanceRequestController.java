package com.github.ageresgit.client.controller;

import com.github.ageresgit.client.model.AtmService;
import com.github.ageresgit.client.model.PaymentCardGenerator;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
public class BalanceRequestController {

    private AtmService atmService;
    private PaymentCardGenerator cardGenerator;


    @GetMapping("/balance")
    private String balanceRequest(@RequestParam("cardPan") String cardPan,
                                  @RequestParam("cardPin") String cardPin
    ) {
        log.info("Client Request: cardPan = " + cardPan + ", cardPin = " + cardPin);
        return atmService.getCardBalance(cardGenerator.paymentCardOf(cardPan, cardPin));
    }

}
