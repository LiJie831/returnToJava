package lijie.learning.itheima.d1.exp2.service.impl;

import lijie.learning.itheima.d1.exp2.dao.IAccountDao;
import lijie.learning.itheima.d1.exp2.dao.impl.AccountDaoImpl;
import lijie.learning.itheima.d1.exp2.service.IAccountService;

public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao = new AccountDaoImpl();
    @Override
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
