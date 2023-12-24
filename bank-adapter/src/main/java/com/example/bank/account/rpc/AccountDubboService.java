package com.example.bank.account.rpc;

import com.example.bank.application.account.AccountApplicationService;
import com.example.bank.application.account.executor.command.AccountDepositCmdExe;
import com.example.bank.application.account.executor.command.AccountWithdrawCmdExe;
import com.example.bank.application.account.executor.query.AccountByAccountIdQryExe;
import com.example.bank.application.client.account.IAccountApplicationService;
import com.example.bank.constant.RPC;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService(timeout = RPC.DEFAULT_TIMEOUT)
public class AccountDubboService extends AccountApplicationService implements IAccountApplicationService {
    public AccountDubboService(AccountByAccountIdQryExe accountByAccountIdQryExe, AccountDepositCmdExe accountDepositCmdExe, AccountWithdrawCmdExe accountWithdrawCmdExe) {
        super(accountByAccountIdQryExe, accountDepositCmdExe, accountWithdrawCmdExe);
    }
}
