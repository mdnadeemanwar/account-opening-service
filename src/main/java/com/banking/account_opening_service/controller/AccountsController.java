package com.banking.account_opening_service.controller;

import com.banking.accountopeningservice.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.banking.accountopeningservice.api.AccountsApi;
import com.banking.accountopeningservice.model.AccountResponse;

import java.time.OffsetDateTime;
import java.util.UUID;

@RestController
public class AccountsController implements AccountsApi{

    @Override
    public ResponseEntity<AccountResponse> openAccount(OpenAccountRequest openAccountRequest){
        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setAccountNumber("1234567890");
        accountResponse.setBalance(openAccountRequest.getInitialDeposit());
        accountResponse.setAccountId(UUID.randomUUID());
        accountResponse.setCustomerId(openAccountRequest.getCustomerId());
        accountResponse.setAccountType(AccountType.SAVINGS);
        accountResponse.setCurrency(openAccountRequest.getCurrency());
        accountResponse.setCreatedAt(OffsetDateTime.now());
        accountResponse.setStatus(AccountStatus.ACTIVE);

        return ResponseEntity.status(HttpStatus.CREATED).body(accountResponse);

    }

    @Override
    public ResponseEntity<AccountResponse> getAccount(UUID accountId){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
