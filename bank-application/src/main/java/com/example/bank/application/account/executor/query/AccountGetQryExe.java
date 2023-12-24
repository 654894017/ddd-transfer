package com.example.bank.application.account.executor.query;

import com.example.bank.account.IAccountRepository;
import com.example.bank.account.entity.Account;
import com.example.bank.application.account.AccountAssembler;
import com.example.bank.application.client.account.dto.AccountDTO;
import com.example.bank.types.AccountId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountGetQryExe {
    private final IAccountRepository accountRepository;
    private final AccountAssembler accountAssembler;

    public AccountDTO get(Long accountId) {
        Account account = accountRepository.find(new AccountId(accountId));
        return accountAssembler.to(account);
    }
}
