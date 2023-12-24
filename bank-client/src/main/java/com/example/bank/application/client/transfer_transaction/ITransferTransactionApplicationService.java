package com.example.bank.application.client.transfer_transaction;


import com.example.bank.application.client.transfer_transaction.dto.TransferTrasactionDTO;
import com.example.bank.application.client.transfer_transaction.dto.command.AccountTransferCmd;
import com.example.bank.application.client.transfer_transaction.dto.query.TransferTransactionPageQry;
import ddd.core.PageResponse;
import ddd.core.SingleResponse;

public interface ITransferTransactionApplicationService {
    SingleResponse<Boolean> transfer(AccountTransferCmd command);
    PageResponse<TransferTrasactionDTO> query(TransferTransactionPageQry qry);
}