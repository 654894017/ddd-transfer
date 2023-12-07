package com.example.bank.gateway;

import com.example.bank.domain.entity.Account;
import com.example.bank.types.AccountId;
import com.example.bank.types.AccountNumber;
import com.example.bank.types.UserId;

public interface IAccountRepository {
    Account find(AccountId id);

    Account find(AccountNumber accountNumber);

    Account find(UserId userId);

    Account save(Account account);
}
