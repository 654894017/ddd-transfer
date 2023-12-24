package com.example.bank.account.web;

import com.example.bank.application.client.transfer_transaction.ITransferTransactionApplicationService;
import com.example.bank.application.client.transfer_transaction.dto.command.AccountTransferCmd;
import com.example.bank.constant.API;
import ddd.core.SingleResponse;
import lombok.RequiredArgsConstructor;
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
        transferApplicationService.transfer(cmd);
        return SingleResponse.getInstance(Boolean.TRUE);
    }
}
