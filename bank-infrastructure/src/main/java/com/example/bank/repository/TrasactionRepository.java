package com.example.bank.repository;

import com.example.bank.application.client.transfer_transaction.dto.TransactionDTO;
import com.example.bank.application.client.transfer_transaction.dto.query.TransferTransactionPageQry;
import com.example.bank.transaction.ITrasactionRepository;
import com.example.bank.transaction.entity.Transaction;
import com.example.bank.transaction.entity.TransactionId;
import ddd.core.PageResponse;

public class TrasactionRepository implements ITrasactionRepository {
    @Override
    public Transaction find(TransactionId transactionId) {
        return null;
    }
    @Override
    public PageResponse<TransactionDTO> query(TransferTransactionPageQry qry) {
        return null;
    }
    @Override
    public Long save(Transaction transaction) {
        return null;
    }
}
