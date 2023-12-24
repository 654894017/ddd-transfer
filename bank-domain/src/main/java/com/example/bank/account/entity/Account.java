package com.example.bank.account.entity;

import com.example.bank.account.exception.DailyLimitExceededException;
import com.example.bank.account.exception.InsufficientFundsException;
import com.example.bank.account.exception.InvalidCurrencyException;
import com.example.bank.types.*;
import lombok.Data;

@Data
public class Account {
    private AccountId id;
    private AccountNumber accountNumber;
    private UserId userId;
    private Money available;
    private Money dailyLimit;
    private Currency currency;

    // 转出
    public void withdraw(Money money) {
        if (this.available.compareTo(money) < 0) {
            throw new InsufficientFundsException();
        }
        if (this.dailyLimit.compareTo(money) < 0) {
            throw new DailyLimitExceededException();
        }
        this.available = this.available.subtract(money);
    }

    // 转入
    public void deposit(Money money) {
        if (!this.getCurrency().equals(money.getCurrency())) {
            throw new InvalidCurrencyException("不支持的货币");
        }
        this.available = this.available.add(money);

    }
}
