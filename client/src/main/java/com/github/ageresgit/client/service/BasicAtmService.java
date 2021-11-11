package com.github.ageresgit.client.service;

import com.github.ageresgit.client.format.BalanceFormat;
import com.github.ageresgit.client.model.AtmService;
import com.github.ageresgit.client.model.PaymentCard;
import com.github.ageresgit.common.Request;
import com.github.ageresgit.common.RequestType;
import com.github.ageresgit.common.Response;
import lombok.NonNull;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import static com.github.ageresgit.common.ResponseType.INVALID_PAN;
import static com.github.ageresgit.common.ResponseType.INVALID_PIN_CODE;

@Service
@Log
public class BasicAtmService implements AtmService {
    @NonNull
    private final long atmId;
    @NonNull
    private final String remoteUrl;

    public BasicAtmService(@Value("${atm.atmId}") long atmId, @Value("${atm.remote.url}") String remoteUrl) {
        this.atmId = atmId;
        this.remoteUrl = remoteUrl;
    }

    @Override
    public String getCardBalance(PaymentCard card) {

        if (!card.isValidPan()) {
            return INVALID_PAN.getDescription();
        }

        if (!card.isValidPin()) {
            return INVALID_PIN_CODE.getDescription();
        }

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Request> request = new HttpEntity<>(new Request(RequestType.CARD_BALANCE, card.getPan(), card.getPin(), atmId));

        try {
            ResponseEntity<Response> responseEntity = restTemplate.postForEntity(remoteUrl, request, Response.class);
            return BalanceFormat.of(responseEntity.getBody()).describe();
        } catch (RestClientException restClientException) {
            log.info("Ошибка сервиса: " + restClientException);
            return BalanceFormat.describeServiceError();
        }
    }
}
