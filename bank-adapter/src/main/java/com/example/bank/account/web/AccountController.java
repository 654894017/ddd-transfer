package com.example.bank.account.web;

import com.example.bank.application.client.account.IAccountApplicationService;
import com.example.bank.application.client.account.dto.command.AccountDepositCmd;
import com.example.bank.application.client.account.dto.command.AccountWithdrawCmd;
import com.example.bank.application.client.transfer_transaction.dto.command.AccountTransferCmd;
import com.example.bank.application.client.transfer_transaction.ITransferTransactionApplicationService;
import com.example.bank.constant.API;
import ddd.core.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(API.WEB_API_PATH + "account")
public class AccountController {
    private final ITransferTransactionApplicationService transferApplicationService;
    private final IAccountApplicationService accountApplicationService;
    @PostMapping("transfer")
    public Response<Boolean> transfer(@Valid AccountTransferCmd cmd, HttpSession session) {
        Long sourceUserId = (Long) session.getAttribute("user_id");
        cmd.setSourceUserId(sourceUserId);
        transferApplicationService.transfer(cmd);
        return Response.getInstance(Boolean.TRUE);
    }
    @PostMapping("deposit")
    public Response<Boolean> deposit(@Valid AccountDepositCmd cmd, HttpSession session) {
        Long sourceUserId = (Long) session.getAttribute("user_id");
        cmd.setSourceUserId(sourceUserId);
        accountApplicationService.deposit(cmd);
        return Response.getInstance(Boolean.TRUE);
    }

    @PostMapping("withdraw")
    public Response<Boolean> withdraw(@Valid AccountWithdrawCmd cmd, HttpSession session) {
        Long sourceUserId = (Long) session.getAttribute("user_id");
        cmd.setSourceUserId(sourceUserId);
        accountApplicationService.withdraw(cmd);
        return Response.getInstance(Boolean.TRUE);
    }
}
