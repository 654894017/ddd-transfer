package com.example.bank.exchange_rate;

import com.example.bank.gateway.IExchangeRateGateway;
import com.example.bank.types.Currency;
import com.example.bank.types.ExchangeRate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ExchangeRateGateway implements IExchangeRateGateway {
    @Override
    public ExchangeRate getExchangeRate(Currency source, Currency target) {
//        if (event_source.equals(target)) {
        return new ExchangeRate(BigDecimal.ONE, source, target);
//        }

    }
}
