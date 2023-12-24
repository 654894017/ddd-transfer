package com.example.bank.application.account;

import com.example.bank.account.entity.Account;
import com.example.bank.application.client.account.dto.AccountDTO;
import org.springframework.stereotype.Component;

@Component
public class AccountAssembler {

    public AccountDTO to(Account account) {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setCurrency(account.getCurrency().getValue());
        //.......
        return accountDTO;
    }

}
