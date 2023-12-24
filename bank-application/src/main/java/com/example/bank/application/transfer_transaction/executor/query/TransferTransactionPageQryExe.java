package com.example.bank.application.transfer_transaction.executor.query;

import com.example.bank.application.client.transfer_transaction.dto.TransactionDTO;
import com.example.bank.application.client.transfer_transaction.dto.query.TransferTransactionPageQry;
import com.example.bank.transaction.ITrasactionRepository;
import ddd.core.PageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TransferTransactionPageQryExe {
    private final ITrasactionRepository transactionRepository;

    public PageResponse<TransactionDTO> query(TransferTransactionPageQry qry) {
        return transactionRepository.query(qry);
    }

}
