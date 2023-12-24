package com.example.bank.transaction;

import com.example.bank.account.entity.Account;
import com.example.bank.types.ExchangeRate;
import com.example.bank.types.Money;
import org.springframework.stereotype.Service;

@Service
public class AccountTransferDomainService {

    public void transfer(Account sourceAccount, Account targetAccount,
                         Money targetMoney, ExchangeRate exchangeRate) {
        Money sourceMoney = exchangeRate.exchageTo(targetMoney);
        sourceAccount.deposit(sourceMoney);
        targetAccount.withdraw(targetMoney);
    }
}
