package com.example.bank.application.account.executor.query;

import com.example.bank.account.IAccountRepository;
import com.example.bank.account.entity.Account;
import com.example.bank.application.account.AccountAssembler;
import com.example.bank.application.client.account.dto.AccountDTO;
import com.example.bank.application.client.account.dto.query.AccountByAccountIdQry;
import com.example.bank.types.AccountId;
import ddd.core.SingleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountByAccountIdQryExe {
    private final IAccountRepository accountRepository;
    private final AccountAssembler accountAssembler;

    public SingleResponse<AccountDTO> get(AccountByAccountIdQry qry) {
        Account account = accountRepository.find(new AccountId(qry.getAccountId()));
        return SingleResponse.of(accountAssembler.to(account));
    }
}
