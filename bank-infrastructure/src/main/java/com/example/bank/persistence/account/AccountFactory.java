package com.example.bank.persistence.account;

import com.example.bank.account.entity.Account;
import com.example.bank.types.*;

public class AccountFactory {
    public static Account toAccount(AccountDO accountDO) {
        Account account = new Account();
        account.setId(new AccountId(accountDO.getId()));
        account.setAccountNumber(new AccountNumber(accountDO.getAccountNumber()));
        account.setUserId(new UserId(accountDO.getUserId()));
        Currency currency = new Currency(accountDO.getCurrency());
        account.setAvailable(new Money(accountDO.getAvailableAmout(), currency));
        account.setDailyLimit(new Money(accountDO.getDailyLimitAmout(), currency));
        return account;
    }

    public static AccountDO fromAccount(Account account) {
        AccountDO accountDO = new AccountDO();
        if (account.getId() != null) {
            accountDO.setId(account.getId().getValue());
        }
        accountDO.setUserId(account.getUserId().getId());
        accountDO.setAccountNumber(account.getAccountNumber().getValue());
        accountDO.setAvailableAmout(account.getAvailable().getAmout());
        accountDO.setDailyLimitAmout(account.getDailyLimit().getAmout());
        accountDO.setCurrency(account.getCurrency().getValue());
        return accountDO;
    }
}
