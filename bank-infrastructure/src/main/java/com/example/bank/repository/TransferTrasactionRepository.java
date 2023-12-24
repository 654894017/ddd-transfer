package com.example.bank.repository;

import com.example.bank.application.client.transfer_transaction.dto.TransferTrasactionDTO;
import com.example.bank.application.client.transfer_transaction.dto.query.TransferTransactionPageQry;
import com.example.bank.transaction.ITransferTrasactionRepository;
import com.example.bank.transaction.entity.TransferTransaction;
import com.example.bank.transaction.type.TransactionId;
import ddd.core.PageResponse;

public class TransferTrasactionRepository implements ITransferTrasactionRepository {
    @Override
    public TransferTransaction find(TransactionId transactionId) {
        return null;
    }

    @Override
    public PageResponse<TransferTrasactionDTO> query(TransferTransactionPageQry qry) {
        return null;
    }
}
