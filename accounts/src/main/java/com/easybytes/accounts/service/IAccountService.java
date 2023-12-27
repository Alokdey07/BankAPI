package com.easybytes.accounts.service;

import com.easybytes.accounts.dto.CustomerDto;

public interface IAccountService {

//    @param customerDto - CustomerDto Object
    void createAccount(CustomerDto customerDto);


    //@param mobileNumber- inputmobile number
    //@return Account details based on a given mobileNumber
    CustomerDto fetchAccount(String mobileNumber);

}
