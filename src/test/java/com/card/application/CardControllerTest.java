package com.card.application;

import com.card.application.exception.InvalidCardNumberException;
import com.card.application.model.CardEntity;
import com.card.application.service.CardService;
import com.card.application.web.CardController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CardControllerTest
{
	@InjectMocks
	CardController cardController;

	@Mock
	CardService cardService;

	@Test
	public void testAddCard() throws InvalidCardNumberException {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		CardEntity card = new CardEntity("Pri","1358954993914435","5000");
		ResponseEntity<CardEntity> responseEntity = cardController.createCard(card);


		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
	}

	@Test
	public void testGetCards()
	{
		// given
		CardEntity card1 = new CardEntity("Pri","1358954993914435","5000");
		CardEntity card2 = new CardEntity("Pri2","1358954993914435","5001");

		List<CardEntity> cards = new ArrayList<CardEntity>();
		cards.add(card1);
		cards.add(card2);

		when(cardService.getCards()).thenReturn(cards);

		// when
		ResponseEntity<List<CardEntity>> result = cardController.getCards();
		// then
		assertThat(result.getBody().size()).isEqualTo(2);

	}
}
