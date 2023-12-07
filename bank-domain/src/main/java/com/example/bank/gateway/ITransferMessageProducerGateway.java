package com.example.bank.gateway;

import com.example.bank.domain.types.TransactionMessage;

public interface ITransferMessageProducerGateway {
    void send(TransactionMessage message);
}
