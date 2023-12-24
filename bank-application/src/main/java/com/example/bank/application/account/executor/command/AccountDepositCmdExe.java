package com.example.bank.application.account.executor.command;

import com.example.bank.account.IAccountRepository;
import com.example.bank.account.entity.Account;
import com.example.bank.account.types.TransactionMessage;
import com.example.bank.application.client.account.dto.command.AccountDepositCmd;
import com.example.bank.gateway.ITransferMessageProducerGateway;
import com.example.bank.types.AccountId;
import com.example.bank.types.Currency;
import com.example.bank.types.Money;
import ddd.core.SingleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountDepositCmdExe {
    private final IAccountRepository accountRepository;
    private final ITransferMessageProducerGateway transferMessageProducerGateway;
    public SingleResponse<Boolean> deposit(AccountDepositCmd command) {
        Account account = accountRepository.find(new AccountId(command.getSourceUserId()));
        account.deposit(new Money(command.getMoney(), new Currency(command.getCurrency())));
        accountRepository.save(account);
        // 发送消息用于审计日志、短信通知、交易记录
        TransactionMessage message = new TransactionMessage(account, new Money(command.getMoney(), new Currency(command.getCurrency())));
        transferMessageProducerGateway.send(message);
        return SingleResponse.buildSuccess();
    }

}
