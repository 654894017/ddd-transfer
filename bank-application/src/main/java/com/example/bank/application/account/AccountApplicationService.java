package com.example.bank.application.account;

import com.example.bank.application.account.executor.command.AccountDepositCmdExe;
import com.example.bank.application.account.executor.command.AccountWithdrawCmdExe;
import com.example.bank.application.account.executor.query.AccountByAccountIdQryExe;
import com.example.bank.application.client.account.IAccountApplicationService;
import com.example.bank.application.client.account.dto.AccountDTO;
import com.example.bank.application.client.account.dto.command.AccountDepositCmd;
import com.example.bank.application.client.account.dto.command.AccountWithdrawCmd;
import com.example.bank.application.client.account.dto.query.AccountByAccountIdQry;
import ddd.core.SingleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountApplicationService implements IAccountApplicationService {
    private final AccountByAccountIdQryExe accountByAccountIdQryExe;
    private final AccountDepositCmdExe accountDepositCmdExe;
    private final AccountWithdrawCmdExe accountWithdrawCmdExe;
    @Override
    public SingleResponse<Boolean> deposit(AccountDepositCmd cmd) {
        return accountDepositCmdExe.deposit(cmd);
    }
    @Override
    public SingleResponse<Boolean> withdraw(AccountWithdrawCmd cmd) {
        return accountWithdrawCmdExe.withdraw(cmd);
    }
    @Override
    public SingleResponse<AccountDTO> get(AccountByAccountIdQry qry) {
        return accountByAccountIdQryExe.get(qry);
    }
}
