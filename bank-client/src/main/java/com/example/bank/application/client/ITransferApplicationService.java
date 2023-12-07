package com.example.bank.application.client;


import com.example.bank.common.Result;

import java.math.BigDecimal;

public interface ITransferApplicationService {

    Result<Boolean> transfer(Long sourceUserId, String targetAccountNumber, BigDecimal targetAmount, String targetCurrency);

}