package com.example.bank.account.rpc;

import com.example.bank.application.client.transfer_transaction.ITransferTransactionApplicationService;
import com.example.bank.application.transfer_transaction.TransferTransactionApplicationService;
import com.example.bank.application.transfer_transaction.TransferTransactionAssembler;
import com.example.bank.application.transfer_transaction.executor.command.TransactionTransferCmdExe;
import com.example.bank.constant.RPC;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService(timeout = RPC.DEFAULT_TIMEOUT)
public class TransferTransactionDubboService extends TransferTransactionApplicationService implements ITransferTransactionApplicationService {
    public TransferTransactionDubboService(TransactionTransferCmdExe transactionTransferCmdExe, TransferTransactionAssembler transferTransactionAssembler) {
        super(transactionTransferCmdExe, transferTransactionAssembler);
    }
}
