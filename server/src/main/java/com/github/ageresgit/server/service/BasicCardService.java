package com.github.ageresgit.server.service;

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
    public String getBalance(String pan, String pin) {
        log.info("Making response for pan = " + pan + ", pin = " + pin);
        Optional<CardEntity> optionalCard = cardCrudRepository.findById(pan);
        log.info("got from db = " + optionalCard.map(x -> x.getPan() + " acc = " + x.getAccount().getBalance() + " cur = " + x.getAccount().getIso().getCurrency()).orElse("NONE"));

        if (optionalCard.isPresent()) {
            CardEntity card = optionalCard.get();
            if (card.getPin().equals(pin)) {
                return ResponseType.SUCCESS.getDescription() + card.getAccount().getBalance() + " " + card.getAccount().getIso().getCurrency().getCurrencyName();
            } else {
                log.info("Returning " + ResponseType.INCORRECT_PIN.getDescription());
                return ResponseType.INCORRECT_PIN.getDescription();
            }
        }

        log.info("Returning " + ResponseType.UNKNOWN_CARD.getDescription());
        return ResponseType.UNKNOWN_CARD.getDescription();
    }
}
