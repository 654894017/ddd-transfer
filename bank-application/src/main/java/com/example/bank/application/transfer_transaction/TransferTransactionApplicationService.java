package com.example.bank.application.transfer_transaction;

import com.example.bank.application.client.transfer_transaction.ITransferTransactionApplicationService;
import com.example.bank.application.client.transfer_transaction.dto.TransferTrasactionDTO;
import com.example.bank.application.client.transfer_transaction.dto.command.AccountTransferCmd;
import com.example.bank.application.client.transfer_transaction.dto.query.TransferTransactionPageQry;
import com.example.bank.application.transfer_transaction.executor.command.TransactionTransferCmdExe;
import com.example.bank.application.transfer_transaction.executor.query.TransferTransactionPageQryExe;
import ddd.core.PageResponse;
import ddd.core.SingleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TransferTransactionApplicationService implements ITransferTransactionApplicationService {
    private final TransactionTransferCmdExe transactionTransferCmdExe;
    private final TransferTransactionAssembler transferTransactionAssembler;
    private final TransferTransactionPageQryExe transferTransactionPageQryExe;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public SingleResponse<Boolean> transfer(AccountTransferCmd cmd) {
        return transactionTransferCmdExe.transfer(cmd.getSourceUserId(),
                cmd.getTargetAccountNumber(), cmd.getTargetAmount(), cmd.getTargetCurrency());
    }
    @Override
    public PageResponse<TransferTrasactionDTO> query(TransferTransactionPageQry qry) {
        return transferTransactionPageQryExe.query(qry);
    }

}
