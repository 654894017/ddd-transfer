package com.example.bank.repository;

import com.example.bank.account.IAccountRepository;
import com.example.bank.account.entity.Account;
import com.example.bank.account.exception.AccountNotFoundException;
import com.example.bank.persistence.account.AccountDO;
import com.example.bank.persistence.account.AccountFactory;
import com.example.bank.persistence.account.AccountMapper;
import com.example.bank.types.AccountId;
import com.example.bank.types.AccountNumber;
import com.example.bank.types.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AccountRepository implements IAccountRepository {
    private final AccountMapper accountDAO;

    @Override
    public Account find(AccountId id) {
        AccountDO accountDO = accountDAO.selectById(id.getValue());
        return AccountFactory.toAccount(accountDO);
    }

    @Override
    public Account find(AccountNumber accountNumber) {
        AccountDO accountDO = accountDAO.selectByAccountNumber(accountNumber.getValue());
        if (accountDO == null) {
            throw new AccountNotFoundException(String.format("账户[%s]不存在", accountNumber.getValue()));
        }
        return AccountFactory.toAccount(accountDO);
    }

    @Override
    public Account find(UserId userId) {
        AccountDO accountDO = accountDAO.selectByUserId(userId.getId());
        if (accountDO == null) {
            throw new AccountNotFoundException("账户不存在");
        }
        return AccountFactory.toAccount(accountDO);
    }

    @Override
    public Account save(Account account) {
        AccountDO accountDO = AccountFactory.fromAccount(account);
        if (accountDO.getId() == null) {
            accountDAO.insert(accountDO);
        } else {
            accountDAO.update(accountDO);
        }
        return AccountFactory.toAccount(accountDO);
    }

}
