package com.easybank.cards.service.Impl;

import com.easybank.cards.constants.CardConstants;
import com.easybank.cards.dto.CardDto;
import com.easybank.cards.entity.Cards;
import com.easybank.cards.exception.CardAlreadyExistsException;
import com.easybank.cards.exception.ResourceNotFoundException;
import com.easybank.cards.mapper.CardsMapper;
import com.easybank.cards.repository.CardRepository;
import com.easybank.cards.service.ICardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;


@Service
@AllArgsConstructor
public class CardServiceImpl implements ICardService {

   private CardRepository cardRepository;
    @Override
    public void createCard(String mobileNumber) {
        Optional<Cards> optionalCards=cardRepository.findByMobileNumber(mobileNumber);
        if(optionalCards.isPresent()) {
            throw new CardAlreadyExistsException("Card already registered with given mobile number: " + mobileNumber);

        }
        cardRepository.save(createNewCard(mobileNumber));
    }

   /* @param mobileNumber - Mobile Number of The customer
    @return the new card details*/

    private Cards createNewCard(String mobileNumber) {
    Cards newCard = new Cards();
    long randomCardNumber = 100000000000L + new Random().nextInt(900000000);
    newCard.setCardName(Long.toString(randomCardNumber));
    newCard.setMobileNumber(mobileNumber);
    newCard.setCardType(CardConstants.CREDIT_CARD);
    newCard.setTotalLimit(CardConstants.NEW_CARD_LIMIT);
    newCard.setAmountUsed(0);
    newCard.setAvailableAmount(CardConstants.NEW_CARD_LIMIT);
    return newCard;
    }

   /*
    @param  mobileNumber - Input mobile number
    @return card details based on a given mobileNumber
*/
    @Override
    public CardDto fetchCard(String mobileNumber) {
        Cards card = cardRepository.findByMobileNumber(mobileNumber).orElseThrow(()->new ResourceNotFoundException("Card","mobileNumber",mobileNumber));
         return CardsMapper.mapToCardDto(card,new CardDto());
    }

   /* @param cardDto - cardDto object
            @return boolean indicating if the update of card detail is successful or not*/

    @Override
    public boolean updateCard(CardDto cardDto) {

        Cards cards = cardRepository.findByCardNumber(cardDto.getCardNumber()).orElseThrow(()->new ResourceNotFoundException("Card","cardNumber",cardDto.getCardNumber()));
        CardsMapper.mapToCards(cardDto,cards);
        cardRepository.save(cards);

        return true;
    }
/*
    @param mobileNumber - Input MobileNumber
            @return boolean indicating if the delete of card details is successful or not*/

    @Override
    public boolean deleteCard(String mobileNumber) {
        Cards cards = cardRepository.findByMobileNumber(mobileNumber).orElseThrow(()->new ResourceNotFoundException("Card", "mobileNumber", mobileNumber));
        cardRepository.deleteById(cards.getCardId());

        return true;
    }
}
