package com.example.bank.account.rpc;

import com.example.bank.application.account.AccountApplicationService;
import com.example.bank.application.account.executor.command.AccountDepositCmdExe;
import com.example.bank.application.account.executor.command.AccountWithdrawCmdExe;
import com.example.bank.application.account.executor.query.AccountGetQryExe;
import com.example.bank.application.client.account.IAccountApplicationService;
import com.example.bank.constant.RPC;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService(timeout = RPC.DEFAULT_TIMEOUT)
public class AccountDubboService extends AccountApplicationService implements IAccountApplicationService {
    public AccountDubboService(AccountGetQryExe accountGetQryExe, AccountDepositCmdExe accountDepositCmdExe, AccountWithdrawCmdExe accountWithdrawCmdExe) {
        super(accountGetQryExe, accountDepositCmdExe, accountWithdrawCmdExe);
    }
}
