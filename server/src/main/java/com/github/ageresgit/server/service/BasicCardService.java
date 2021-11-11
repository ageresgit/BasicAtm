package com.github.ageresgit.server.service;

import com.github.ageresgit.common.Response;
import com.github.ageresgit.common.ResponseType;
import com.github.ageresgit.server.entity.CardEntity;
import com.github.ageresgit.server.model.CardService;
import com.github.ageresgit.server.repository.CardCrudRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class BasicCardService implements CardService {
    private CardCrudRepository cardCrudRepository;

    @Override
    public Response getBalance(String pan, String pin) {
        Optional<CardEntity> optionalCard = cardCrudRepository.findById(pan);

        if (optionalCard.isPresent()) {
            CardEntity card = optionalCard.get();
            if (card.getPin().equals(pin)) {
                return Response.builder().responseType(ResponseType.SUCCESS)
                        .amount(card.getAccount().getBalance())
                        .currency(card.getAccount().getIso().getCurrency()).build();
            } else {
                return Response.builder().responseType(ResponseType.INCORRECT_PIN).build();
            }
        }

        return Response.builder().responseType(ResponseType.UNKNOWN_CARD).build();
    }
}
