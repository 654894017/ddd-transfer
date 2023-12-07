package com.example.bank.application;

import com.example.bank.application.client.ITransferApplicationService;
import com.example.bank.common.Result;
import com.example.bank.domain.AccountTransferDomainService;
import com.example.bank.domain.entity.Account;
import com.example.bank.domain.types.TransactionMessage;
import com.example.bank.gateway.IAccountRepository;
import com.example.bank.gateway.IExchangeRateGateway;
import com.example.bank.gateway.ITransferMessageProducerGateway;
import com.example.bank.types.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TransferApplicationService implements ITransferApplicationService {
    private final IAccountRepository accountRepository;
    private final ITransferMessageProducerGateway transferMessageProducerGateway;
    private final IExchangeRateGateway exchangeRateGateway;
    private final AccountTransferDomainService accountTransferDomainService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> transfer(Long sourceUserId, String targetAccountNumber, BigDecimal targetAmount, String targetCurrency) {
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

        return Result.success(true);
    }
}
