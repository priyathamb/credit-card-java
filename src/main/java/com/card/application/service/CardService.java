package com.card.application.service;

import java.util.ArrayList;
import java.util.List;

import com.card.application.exception.InvalidCardNumberException;
import com.card.application.model.CardEntity;
import com.card.application.util.LuhnAlgorithmMain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.card.application.repository.CardRepository;
 
@Service
public class CardService {
     
    @Autowired
    CardRepository repository;
     
    public List<CardEntity> getCards()
    {
        List<CardEntity> cardList = repository.findAll();
         
        if(cardList.size() > 0) {
            return cardList;
        } else {
            return new ArrayList<CardEntity>();
        }
    }
     
    public CardEntity createCard(CardEntity entity) throws InvalidCardNumberException
    {
       /* Optional<CardEntity> card = repository.findById(Long.parseLong(entity.getCardNumber()));
         
        if(card.isPresent())
        {
            CardEntity newEntity = card.get();
            newEntity.setCardLimit(entity.getCardLimit());
            newEntity.setGivenName(entity.getGivenName());
            newEntity.setCardNumber(entity.getCardNumber());
 
            newEntity = repository.save(newEntity);
             
            return newEntity;
        } else {*/

        if (LuhnAlgorithmMain.isValidCreditCardNumber(entity.getCardNumber()))
        {
            entity = repository.save(entity);
            return entity;
        }

        else
            // throw our custom exception
            throw new InvalidCardNumberException("Invalid Card Number");

    }
}