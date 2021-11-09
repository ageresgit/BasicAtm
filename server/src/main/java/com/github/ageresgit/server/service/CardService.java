package com.github.ageresgit.server.service;

import com.github.ageresgit.server.entity.CardEntity;
import com.github.ageresgit.server.repository.CardCrudRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CardService {
    private CardCrudRepository cardCrudRepository;

    public String getBalance(String pan, String pin) {
        Optional<CardEntity> optionalCard = cardCrudRepository.findById(pan);

        if (optionalCard.isPresent()) {
            CardEntity card = optionalCard.get();
            if (card.getPin().equalsIgnoreCase(pin)) {
                return "Balance = " + card.getAccount().getBalance() + " " + card.getAccount().getCurrency().getCurrency();
            }
            else {
                return "Incorrect PIN";
            }
        }
        return "Cannot find card by pan: " + pan;
    }
}
