package com.easybytes.accounts.service.impl;

import com.easybytes.accounts.constants.AccountConstants;
import com.easybytes.accounts.dto.AccountsDto;
import com.easybytes.accounts.dto.CustomerDto;
import com.easybytes.accounts.entity.Account;
import com.easybytes.accounts.entity.Customer;
import com.easybytes.accounts.exception.CustomerAlreadyExistsException;
import com.easybytes.accounts.exception.ResourceNotFoundException;
import com.easybytes.accounts.mapper.AccountMapper;
import com.easybytes.accounts.mapper.CustomerMapper;
import com.easybytes.accounts.repository.AccountRepository;
import com.easybytes.accounts.repository.CustomerRepository;
import com.easybytes.accounts.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountService {

    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;

    @Override
    public void createAccount(CustomerDto customerDto) {

        Customer customer = CustomerMapper.mapToCustomer(customerDto,new Customer());
        Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customerDto.getMobileNumber());
        if(optionalCustomer.isPresent()){
            throw new CustomerAlreadyExistsException("Customer already registered with given mobileNumber "+customerDto.getMobileNumber());
        }

//        customer.setCreatedAt(LocalDateTime.now());
//        customer.setCreatedBy("Anonymous");
        Customer savedCustomer = customerRepository.save(customer);
        accountRepository.save(createNewAccount(savedCustomer));


    }




    private Account createNewAccount(Customer customer){
        Account newAccount = new Account();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber= 10000000000L + new Random().nextInt(900000000);
        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountConstants.SAVINGS);
        newAccount.setBranchAddress(AccountConstants.ADDRESS);
        return newAccount;

    }

    @Override
    public CustomerDto fetchAccount(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(() -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber));
        Account account = accountRepository.findByCustomerId(customer.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Account", "customerId", String.valueOf(customer.getCustomerId())));
        CustomerDto customerDto = CustomerMapper.mapToCustomerDto(customer, new CustomerDto());
        customerDto.setAccountsDto(AccountMapper.mapToAccountDto(account,new AccountsDto()));
        return customerDto;
    }

    @Override
    public boolean updateAccount(CustomerDto customerDto) {
        boolean isUpdate=false;
        AccountsDto accountsDto=customerDto.getAccountsDto();
        if(accountsDto != null){
            Account account = accountRepository.findById(accountsDto.getAccountNumber()).orElseThrow(()->new ResourceNotFoundException("Account","AccountNumber",String.valueOf(accountsDto.getAccountNumber())));
            AccountMapper.mapToAccounts(accountsDto,account);
            account =accountRepository.save(account);

            Long customerId=account.getCustomerId();
            Customer customer=customerRepository.findById(customerId).orElseThrow(()->new ResourceNotFoundException("Customer","customerId",String.valueOf(customerId)));

            CustomerMapper.mapToCustomer(customerDto,customer);
            customerRepository.save(customer);
            isUpdate=true;

        }

        return isUpdate;
    }

    @Override
    public boolean deleteAccount(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(() -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber));
   accountRepository.deleteById(customer.getCustomerId());
   customerRepository.deleteById(customer.getCustomerId());
   return true;

    }
}
