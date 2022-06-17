package com.card.application.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CARD")
@NoArgsConstructor
@AllArgsConstructor
public class CardEntity {

	/*public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Id
	@Column(name="id")
	private Long id;
    */
    @Column(name="given_name")
    private String givenName;

	@Id
    @Column(name="card_number")
    private String cardNumber;
    
    @Column(name="card_limit", nullable=false, length=200)
    private String cardLimit;

	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardLimit() {
		return cardLimit;
	}

	public void setCardLimit(String cardLimit) {
		this.cardLimit = cardLimit;
	}

	@Override
	public String toString() {
		return "CardEntity{" +
				//"id=" + id +
				" givenName='" + givenName + '\'' +
				", cardNumber='" + cardNumber + '\'' +
				", cardLimit='" + cardLimit + '\'' +
				'}';
	}
}