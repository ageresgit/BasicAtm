package com.github.ageresgit.client;

import com.github.ageresgit.common.Request;
import com.github.ageresgit.common.RequestType;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@NoArgsConstructor
public class BalanceRequestController {

    @GetMapping("/balance")
    private String balanceRequest(@RequestParam("cardPan") String cardPan,
                                   @RequestParam("cardPin") String cardPin
    ) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Request> request = new HttpEntity<>(new Request(RequestType.CARD_BALANCE, cardPan, cardPin));

        ResponseEntity<String> responseEntityStr = restTemplate.
                postForEntity("http://127.0.0.1:9090/balancerequest", request, String.class);


        return responseEntityStr.getBody();
    }

}
