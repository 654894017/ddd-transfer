package com.example.bank.account.rpc;

import com.example.bank.application.account.AccountApplicationService;
import com.example.bank.application.account.executor.command.AccountDepositCmdExe;
import com.example.bank.application.account.executor.command.AccountWithdrawCmdExe;
import com.example.bank.application.account.executor.query.AccountGetQryExe;
import com.example.bank.application.client.account.IAccountApplicationService;
import com.example.bank.application.client.transfer_transaction.ITransferTransactionApplicationService;
import com.example.bank.application.transfer_transaction.TransferTransactionApplicationService;
import com.example.bank.application.transfer_transaction.TransferTransactionAssembler;
import com.example.bank.application.transfer_transaction.executor.command.TransactionTransferCmdExe;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class TransferTransactionDubboService extends TransferTransactionApplicationService implements ITransferTransactionApplicationService {
    public TransferTransactionDubboService(TransactionTransferCmdExe transactionTransferCmdExe, TransferTransactionAssembler transferTransactionAssembler) {
        super(transactionTransferCmdExe, transferTransactionAssembler);
    }
}
