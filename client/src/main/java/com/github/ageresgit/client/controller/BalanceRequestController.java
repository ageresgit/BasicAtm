package com.github.ageresgit.client.controller;

import com.github.ageresgit.client.model.AtmService;
import com.github.ageresgit.client.model.PaymentCardGenerator;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
public class BalanceRequestController {

    private AtmService atmService;
    private PaymentCardGenerator cardGenerator;

    @GetMapping("/balance")
    private String balanceRequest(@RequestParam("cardPan") String cardPan,
                                  @RequestParam("cardPin") String cardPin
    ) {
        return atmService.getCardBalance(cardGenerator.paymentCardOf(cardPan, cardPin));
    }

}
