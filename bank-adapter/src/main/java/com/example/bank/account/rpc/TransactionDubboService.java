package com.example.bank.account.rpc;

import com.example.bank.application.client.transfer_transaction.ITransactionApplicationService;
import com.example.bank.application.transaction.TransactionApplicationService;
import com.example.bank.application.transaction.TransactionAssembler;
import com.example.bank.application.transaction.executor.command.TransactionTransferCmdExe;
import com.example.bank.application.transaction.executor.query.TransferTransactionPageQryExe;
import com.example.bank.constant.RPC;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService(timeout = RPC.DEFAULT_TIMEOUT)
public class TransactionDubboService extends TransactionApplicationService implements ITransactionApplicationService {
    public TransactionDubboService(TransactionTransferCmdExe transactionTransferCmdExe, TransferTransactionPageQryExe transferTransactionPageQryExe) {
        super(transactionTransferCmdExe, transferTransactionPageQryExe);
    }
}
