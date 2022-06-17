package com.card.application.repository;

import com.card.application.model.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository
        extends JpaRepository<CardEntity, Long> {
 
}
