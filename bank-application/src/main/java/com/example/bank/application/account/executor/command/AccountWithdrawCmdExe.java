package com.example.bank.application.account.executor.command;

import com.example.bank.account.IAccountRepository;
import com.example.bank.account.entity.Account;
import com.example.bank.application.client.account.dto.command.AccountWithdrawCmd;
import com.example.bank.application.client.account.dto.event.AccountWithdrawSucceedEvent;
import com.example.bank.gateway.IAccountMessageProducerGateway;
import com.example.bank.transaction.ITrasactionRepository;
import com.example.bank.transaction.entity.Transaction;
import com.example.bank.types.AccountId;
import com.example.bank.types.Currency;
import com.example.bank.types.Money;
import ddd.core.SingleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountWithdrawCmdExe {
    private final IAccountRepository accountRepository;
    private final IAccountMessageProducerGateway accountMessageProducerGateway;
    private final ITrasactionRepository transferTrasactionRepository;

    public SingleResponse<Boolean> withdraw(AccountWithdrawCmd cmd) {
        Account account = accountRepository.find(new AccountId(cmd.getSourceUserId()));
        account.withdraw(new Money(cmd.getMoney(), new Currency(cmd.getCurrency())));
        Transaction transaction = new Transaction().toWithdramTransaction(account.getId(), new Money(cmd.getMoney(), new Currency(cmd.getCurrency())));
        accountRepository.save(account);
        // 记录交易记录
        Long transferTransactionId = transferTrasactionRepository.save(transaction);
        // 发送消息用于审计日志、短信通知
        AccountWithdrawSucceedEvent event = new AccountWithdrawSucceedEvent(
                transferTransactionId, account.getId().getValue(),
                cmd.getMoney(), cmd.getCurrency()
        );
        accountMessageProducerGateway.send(event);
        return SingleResponse.buildSuccess();
    }

}
