package com.example.bank.application.account.executor.command;

import com.example.bank.account.IAccountRepository;
import com.example.bank.account.entity.Account;
import com.example.bank.account.types.TransactionMessage;
import com.example.bank.application.client.account.dto.command.AccountWithdrawCmd;
import com.example.bank.gateway.ITransferMessageProducerGateway;
import com.example.bank.types.AccountId;
import com.example.bank.types.Currency;
import com.example.bank.types.Money;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountWithdrawCmdExe {
    private final IAccountRepository accountRepository;
    private final ITransferMessageProducerGateway transferMessageProducerGateway;
    public void withdraw(AccountWithdrawCmd cmd) {
        Account account = accountRepository.find(new AccountId(cmd.getSourceUserId()));
        account.withdraw(new Money(cmd.getMoney(), new Currency(cmd.getCurrency())));
        accountRepository.save(account);
        // 发送消息用于审计日志、短信通知、交易记录
        TransactionMessage message = new TransactionMessage(account, new Money(cmd.getMoney(), new Currency(cmd.getCurrency())));
        transferMessageProducerGateway.send(message);
    }

}
