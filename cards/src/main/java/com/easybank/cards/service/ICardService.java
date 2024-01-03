package com.easybank.cards.service;

import com.easybank.cards.dto.CardDto;

public interface ICardService {
/*

    @param mobileNumber - Mobile Number of the Customer
*/
    void createCard(String mobileNumber);
   /*
    @param mobileNumber - input mobile number
*/

    CardDto fetchCard(String mobileNumber);

   /* @param cardDto - CardDto Object
            @return boolean indicating if update of card details is successful or not
    */
    boolean updateCard(CardDto cardDto);


    /*@param mobileNumber - Input Mobile Number
    @return boolean indicating if the delete of card details is successful or not*/

    boolean deleteCard(String mobileNumber);



}
