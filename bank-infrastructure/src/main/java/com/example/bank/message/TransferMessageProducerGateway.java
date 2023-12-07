package com.example.bank.message;

import com.example.bank.domain.types.TransactionMessage;
import com.example.bank.gateway.ITransferMessageProducerGateway;
import org.springframework.stereotype.Service;

@Service
public class TransferMessageProducerGateway implements ITransferMessageProducerGateway {
    @Override
    public void send(TransactionMessage message) {

    }
}
