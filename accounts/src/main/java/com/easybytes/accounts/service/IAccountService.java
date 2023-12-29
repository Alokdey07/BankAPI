package com.easybytes.accounts.service;

import com.easybytes.accounts.dto.CustomerDto;

public interface IAccountService {

//    @param customerDto - CustomerDto Object
    void createAccount(CustomerDto customerDto);


    //@param mobileNumber- inputmobile number
    //@return Account details based on a given mobileNumber
    CustomerDto fetchAccount(String mobileNumber);

//    @param customerDto - customerDto object
//    @return boolean indicating if the update of account detail is successful or not
    boolean updateAccount(CustomerDto customerDto);

/*

    @param mobileNumber - input mobile number
    @return boolean indicating if the delete of account deteils is successfull or not
*/

    boolean deleteAccount(String mobileNumber);

}
