package com.github.ageresgit.client.service;

import com.github.ageresgit.client.model.AtmService;
import com.github.ageresgit.client.model.PaymentCard;
import com.github.ageresgit.common.Request;
import com.github.ageresgit.common.RequestType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class BasicAtmService implements AtmService {
    private final long atmId;
    private final String remoteUrl;

    public BasicAtmService(@Value("${atm.atmId}") long atmId, @Value("${atm.remote.url}") String remoteUrl) {
        this.atmId = atmId;
        this.remoteUrl = remoteUrl;
    }

    @Override
    public String getCardBalance(PaymentCard card) {

        if (!card.isValidPan()) {
            return "Некорректный формат номера карты!";
        }

        if (!card.isValidPin()) {
            return "Некорректный формат ПИН-кода!";
        }

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Request> request = new HttpEntity<>(new Request(RequestType.CARD_BALANCE, card.getPan(), card.getPin(), atmId));

        try {
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(remoteUrl, request, String.class);
            return responseEntity.getBody();
        } catch (RestClientException restClientException) {
            log.info("Error: " + restClientException);
            return "Сервис временно недоступен!";
        }
    }

}
