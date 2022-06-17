package com.card.application.web;

import java.util.List;

import com.card.application.exception.InvalidCardNumberException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.card.application.model.CardEntity;
import com.card.application.service.CardService;
 
@RestController
@CrossOrigin("http://localhost:3000")
public class CardController
{
    @Autowired
    CardService service;

    @GetMapping(value = "/getCards")
    public ResponseEntity<List<CardEntity>> getCards() {
        List<CardEntity> list = service.getCards();
 
        return new ResponseEntity<List<CardEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @PostMapping(value = "/addCard", consumes = "application/json", produces = "application/json")
    public ResponseEntity<CardEntity> createCard(@RequestBody CardEntity card)
                                                    throws InvalidCardNumberException {
        CardEntity updated = service.createCard(card);
        return new ResponseEntity<CardEntity>(updated, new HttpHeaders(), HttpStatus.CREATED);
    }
 
}