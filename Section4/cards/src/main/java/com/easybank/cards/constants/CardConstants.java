package com.easybank.cards.constants;

import lombok.NoArgsConstructor;


public final class CardConstants {

private CardConstants(){
//restrict initialization
}
public static final String CREDIT_CARD = "Card_Card";
public static final int NEW_CARD_LIMIT = 1_00_000;

    public static final String STATUS_200 = "200";
   // public static final String MESSAGE_200 = "OK - Request successful.";
public static final String STATUS_201 = "201";
public static final String MESSAGE_201 = "Resource successfully created.";
public static final String MESSAGE_200 = "Request processed successfully";
public static final String STATUS_417 = "417";

public static final String MESSAGE_417_UPDATE="Update operation failed. Please try again or contact Dev team";
public static final String MESSAGE_417_DELETE="Delete operation failed.Please try again or contact Dev";


}
