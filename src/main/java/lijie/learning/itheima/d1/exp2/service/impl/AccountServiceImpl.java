package lijie.learning.itheima.d1.exp2.service.impl;

import lijie.learning.itheima.d1.exp2.dao.IAccountDao;
import lijie.learning.itheima.d1.exp2.domain.Account;
import lijie.learning.itheima.d1.exp2.service.IAccountService;
import lijie.learning.itheima.d1.factory.BeanFactory;
import lombok.Setter;

import java.util.Date;
import java.util.List;


public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao;
    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }


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
}
