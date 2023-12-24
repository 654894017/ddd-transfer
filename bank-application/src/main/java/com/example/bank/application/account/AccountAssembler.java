package com.example.bank.application.account;

import com.example.bank.account.entity.Account;
import com.example.bank.application.client.account.dto.AccountDTO;
import com.example.bank.application.client.account.dto.command.AccountCreateCmd;
import org.springframework.stereotype.Component;

@Component
public class AccountAssembler {

    // 这边可以调用基础设施接口，因为有些属性需要调用服务获取

    public AccountDTO to(Account account) {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setCurrency(account.getCurrency().getValue());
        //.......
        return accountDTO;
    }

    public Account to(AccountCreateCmd cmd) {
        return null;
    }

}
