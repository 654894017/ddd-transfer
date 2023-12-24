package com.example.bank.account.types;

import com.example.bank.account.entity.Account;
import com.example.bank.types.Money;

public class TransactionMessage {
    public TransactionMessage(Account sourceAccount, Account targetAccount, Money targetMoney) {

    }

    public TransactionMessage(Account sourceAccount, Money targetMoney) {

    }
}
