package com.example.bank.repository;

import com.example.bank.domain.entity.Account;
import com.example.bank.exception.AccountNotFoundException;
import com.example.bank.gateway.IAccountRepository;
import com.example.bank.persistence.AccountBuilder;
import com.example.bank.persistence.AccountDO;
import com.example.bank.persistence.AccountMapper;
import com.example.bank.types.AccountId;
import com.example.bank.types.AccountNumber;
import com.example.bank.types.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AccountRepository implements IAccountRepository {
    private final AccountMapper accountDAO;
    private final AccountBuilder accountBuilder;
    @Override
    public Account find(AccountId id) {
        AccountDO accountDO = accountDAO.selectById(id.getValue());
        return accountBuilder.toAccount(accountDO);
    }
    @Override
    public Account find(AccountNumber accountNumber) {
        AccountDO accountDO = accountDAO.selectByAccountNumber(accountNumber.getValue());
        if (accountDO == null) {
            throw new AccountNotFoundException(String.format("账户[%s]不存在", accountNumber.getValue()));
        }
        return accountBuilder.toAccount(accountDO);
    }
    @Override
    public Account find(UserId userId) {
        AccountDO accountDO = accountDAO.selectByUserId(userId.getId());
        if (accountDO == null) {
            throw new AccountNotFoundException("账户不存在");
        }
        return accountBuilder.toAccount(accountDO);
    }
    @Override
    public Account save(Account account) {
        AccountDO accountDO = accountBuilder.fromAccount(account);
        if (accountDO.getId() == null) {
            accountDAO.insert(accountDO);
        } else {
            accountDAO.update(accountDO);
        }
        return accountBuilder.toAccount(accountDO);
    }

}
