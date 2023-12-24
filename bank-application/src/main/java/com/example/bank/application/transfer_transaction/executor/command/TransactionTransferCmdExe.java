package com.example.bank.application.transfer_transaction.executor.command;

import com.example.bank.account.IAccountRepository;
import com.example.bank.account.entity.Account;
import com.example.bank.account.types.TransactionMessage;
import com.example.bank.gateway.IExchangeRateGateway;
import com.example.bank.gateway.ITransferMessageProducerGateway;
import com.example.bank.transaction.AccountTransferDomainService;
import com.example.bank.types.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TransactionTransferCmdExe {
    private final IAccountRepository accountRepository;
    private final ITransferMessageProducerGateway transferMessageProducerGateway;
    private final IExchangeRateGateway exchangeRateGateway;
    private final AccountTransferDomainService accountTransferDomainService;

    public void transfer(Long sourceUserId, String targetAccountNumber, BigDecimal targetAmount, String targetCurrency) {
        Money targetMoney = new Money(targetAmount, new Currency(targetCurrency));

        Account sourceAccount = accountRepository.find(new UserId(sourceUserId));

        Account targetAccount = accountRepository.find(new AccountNumber(targetAccountNumber));

        ExchangeRate exchangeRate = exchangeRateGateway.getExchangeRate(sourceAccount.getCurrency(), targetMoney.getCurrency());

        accountTransferDomainService.transfer(sourceAccount, targetAccount, targetMoney, exchangeRate);
        accountRepository.save(sourceAccount);
        accountRepository.save(targetAccount);

        // 发送消息用于审计日志、短信通知、交易记录
        TransactionMessage message = new TransactionMessage(sourceAccount, targetAccount, targetMoney);
        transferMessageProducerGateway.send(message);
    }
}
