package com.example.bank.application.account;

import com.example.bank.application.account.executor.command.AccountDepositCmdExe;
import com.example.bank.application.account.executor.command.AccountWithdrawCmdExe;
import com.example.bank.application.account.executor.query.AccountGetQryExe;
import com.example.bank.application.client.account.IAccountApplicationService;
import com.example.bank.application.client.account.dto.AccountDTO;
import com.example.bank.application.client.account.dto.command.AccountDepositCmd;
import com.example.bank.application.client.account.dto.command.AccountWithdrawCmd;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountApplicationService implements IAccountApplicationService {
    private final AccountGetQryExe accountGetQryExe;
    private final AccountDepositCmdExe accountDepositCmdExe;
    private final AccountWithdrawCmdExe accountWithdrawCmdExe;
    @Override
    public void deposit(AccountDepositCmd cmd) {
        accountDepositCmdExe.deposit(cmd);
    }
    @Override
    public void withdraw(AccountWithdrawCmd cmd) {
        accountWithdrawCmdExe.withdraw(cmd);
    }
    @Override
    public AccountDTO get(Long accountId) {
        return accountGetQryExe.get(accountId);
    }
}
