package com.example.bank.gateway;

import com.example.bank.account.types.TransactionMessage;

public interface ITransferMessageProducerGateway {
    void send(TransactionMessage message);
}
