package com.example.bank.transaction;

import com.example.bank.application.client.transfer_transaction.dto.TransferTrasactionDTO;
import com.example.bank.application.client.transfer_transaction.dto.query.TransferTransactionPageQry;
import com.example.bank.transaction.entity.TransferTransaction;
import com.example.bank.transaction.type.TransactionId;
import ddd.core.PageResponse;

public interface ITransferTrasactionRepository {
    TransferTransaction find(TransactionId transactionId);
    PageResponse<TransferTrasactionDTO> query(TransferTransactionPageQry qry);
}
