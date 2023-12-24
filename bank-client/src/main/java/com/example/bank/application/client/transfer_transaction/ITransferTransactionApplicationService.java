package com.example.bank.application.client.transfer_transaction;


import com.example.bank.application.client.transfer_transaction.dto.command.AccountTransferCmd;
import ddd.core.SingleResponse;

public interface ITransferTransactionApplicationService {
    SingleResponse<Boolean> transfer(AccountTransferCmd command);
}