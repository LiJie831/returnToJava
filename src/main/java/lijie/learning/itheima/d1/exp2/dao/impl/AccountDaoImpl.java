package lijie.learning.itheima.d1.exp2.dao.impl;

import lijie.learning.itheima.d1.exp2.dao.IAccountDao;
import lijie.learning.itheima.d1.exp2.domain.Account;

import java.util.Date;
import java.util.List;

//账户的持久层实现类
public class AccountDaoImpl implements IAccountDao {
    private QueryRunner runner;

    @Override
    public List<Account> findAllAccount() {
        return null;
    }

    @Override
    public Account findAccountById(Integer id) {
        return null;
    }

    @Override
    public void saveAccount(Account account) {

    }

    @Override
    public void deleteAccount(Integer id) {

    }

    @Override
    public void updateAccount(Account account) {

    }
}
