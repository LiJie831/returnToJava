package lijie.learning.itheima.d3.service.impl;

import lijie.learning.itheima.d3.dao.IAccountDao;
import lijie.learning.itheima.d3.domain.Account;
import lijie.learning.itheima.d3.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountDao accountDao;


    @Override
    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    @Override
    public Account findAccountById(Integer id) {
        return accountDao.findAccountById(id);
    }

    @Override
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    @Override
    public void deleteAccount(Integer id) {
        accountDao.deleteAccount(id);
    }

    @Override
    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }
    @Override
    public void transfer(String sourceName, String targetName, Float money) {

    }
}
