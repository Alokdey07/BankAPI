package com.easybank.cards.mapper;

import com.easybank.cards.dto.CardDto;
import com.easybank.cards.entity.Cards;

public class CardsMapper {

    public static CardDto mapToCardDto(Cards cards,CardDto cardDto) {
        cardDto.setCardNumber(cards.getCardName());
        cardDto.setCardType(cards.getCardType());
        cardDto.setMobileNumber(cards.getMobileNumber());
        cardDto.setTotalLimit(cards.getTotalLimit());
        cardDto.setAvailableAmount(cards.getAvailableAmount());
        cardDto.setAmountUsed(cards.getAmountUsed());
        return cardDto;
    }

    public static Cards mapToCards(CardDto cardsDto, Cards cards) {
        cards.setCardNumber(cardsDto.getCardNumber());
        cards.setCardType(cardsDto.getCardType());
        cards.setMobileNumber(cardsDto.getMobileNumber());
        cards.setTotalLimit(cardsDto.getTotalLimit());
        cards.setAvailableAmount(cardsDto.getAvailableAmount());
        cards.setAmountUsed(cardsDto.getAmountUsed());
        return cards;
    }
}
