package com.example.bank.application.client.transfer_transaction;


import com.example.bank.application.client.transfer_transaction.dto.command.AccountTransferCmd;

public interface ITransferTransactionApplicationService {
    void transfer(AccountTransferCmd command);
}