package com.example.bank.account.web;

import com.example.bank.application.client.transfer_transaction.dto.TransferTrasactionDTO;
import com.example.bank.application.client.transfer_transaction.dto.query.TransferTransactionPageQry;
import com.example.bank.application.client.transfer_transaction.ITransferTransactionApplicationService;
import com.example.bank.application.client.transfer_transaction.dto.command.AccountTransferCmd;
import com.example.bank.constant.API;
import ddd.core.PageResponse;
import ddd.core.SingleResponse;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.common.utils.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(API.WEB_API_PATH + "transaction")
public class TransferTransactionController {
    private final ITransferTransactionApplicationService transferApplicationService;
    @PostMapping("transfer")
    public SingleResponse<Boolean> transfer(@Valid AccountTransferCmd cmd, HttpSession session) {
        Long sourceUserId = (Long) session.getAttribute("user_id");
        cmd.setSourceUserId(sourceUserId);
        return transferApplicationService.transfer(cmd);
    }


    @GetMapping()
    public PageResponse<TransferTrasactionDTO> query(@Valid TransferTransactionPageQry qry, HttpSession session) {
        Long sourceUserId = (Long) session.getAttribute("user_id");
        qry.setAccountId(sourceUserId);
        return transferApplicationService.query(qry);
    }
}
