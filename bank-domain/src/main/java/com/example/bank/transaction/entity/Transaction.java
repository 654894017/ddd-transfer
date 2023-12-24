package com.example.bank.transaction.entity;

import com.example.bank.types.AccountId;
import com.example.bank.types.Money;
import lombok.Data;

@Data
public class Transaction {
    @SuppressWarnings("unused")
    private long id;
    private Long createTime;
    private AccountId fromAccountId;
    private AccountId toAccountId;
    private Money money;
    private TransactionType transactionType;

    public Transaction() {

    }
    public Transaction toTransferTransaction(AccountId fromAccountId, AccountId toAccountId, Money money) {
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.money = money;
        this.createTime = System.currentTimeMillis();
        this.transactionType = TransactionType.TRANSFER;
        return this;
    }

    public Transaction toDepositTransaction(AccountId fromAccountId, Money money) {
        this.fromAccountId = fromAccountId;
        this.money = money;
        this.createTime = System.currentTimeMillis();
        this.transactionType = TransactionType.DEPOSIT;
        return this;
    }

    public Transaction toWithdramTransaction(AccountId fromAccountId, Money money) {
        this.fromAccountId = fromAccountId;
        this.money = money;
        this.createTime = System.currentTimeMillis();
        this.transactionType = TransactionType.WITHDRAW;
        return this;
    }

}