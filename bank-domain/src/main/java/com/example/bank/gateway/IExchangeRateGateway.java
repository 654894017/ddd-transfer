package com.example.bank.gateway;

import com.example.bank.types.Currency;
import com.example.bank.types.ExchangeRate;

public interface IExchangeRateGateway {
    ExchangeRate getExchangeRate(Currency source, Currency target);

}

