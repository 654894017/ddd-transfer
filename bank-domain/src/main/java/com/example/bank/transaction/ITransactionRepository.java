package com.example.bank.transaction;

import com.example.bank.transaction.entity.TransferTransaction;
import com.example.bank.types.TransactionId;

public interface ITransactionRepository {
    TransferTransaction find(TransactionId transactionId);

}
