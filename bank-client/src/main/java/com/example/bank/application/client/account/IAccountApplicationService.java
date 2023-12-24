package com.example.bank.application.client.account;


import com.example.bank.application.client.account.dto.AccountDTO;
import com.example.bank.application.client.account.dto.command.AccountDepositCmd;
import com.example.bank.application.client.account.dto.command.AccountWithdrawCmd;
import com.example.bank.application.client.account.dto.query.AccountByAccountIdQry;
import ddd.core.SingleResponse;

public interface IAccountApplicationService {
    SingleResponse<Boolean> deposit(AccountDepositCmd cmd);

    SingleResponse<Boolean> withdraw(AccountWithdrawCmd cmd);

    SingleResponse<AccountDTO> get(AccountByAccountIdQry qry);
}