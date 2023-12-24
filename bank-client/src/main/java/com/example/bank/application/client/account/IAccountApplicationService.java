package com.example.bank.application.client.account;


import com.example.bank.application.client.account.dto.AccountDTO;
import com.example.bank.application.client.account.dto.command.AccountDepositCmd;
import com.example.bank.application.client.account.dto.command.AccountWithdrawCmd;

public interface IAccountApplicationService {
    void deposit(AccountDepositCmd cmd);
    void withdraw(AccountWithdrawCmd cmd);
    AccountDTO get(Long accountId);
}