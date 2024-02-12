package com.easybytes.loans.service;

import com.easybytes.loans.dto.LoansDto;

public interface ILoansService {
   /* @param mobileNumber - Mobile number of the Customer*/
    void createLoan(String mobileNumber);

    /*@param mobileNumber - Input mobile number
     @return Loan Details based on a given mobileNumber*/


    LoansDto fetchLoan(String mobileNumber);

    /*@param loanDto - loansDto Object
            @return boolean indicating if the update of card details is successful or not*/
boolean updateLoan(LoansDto loansDto);

/**
 *
 * @param mobileNumber - Input Mobile Number
 * @return boolean indicating if the delete of loan details is successful or not
 */
boolean deleteLoan(String mobileNumber);

}
