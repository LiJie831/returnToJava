package lijie.learning.itheima.d1.exp2.service;

import lijie.learning.itheima.d1.exp2.domain.Account;

import java.util.List;

public interface IAccountService {
    List<Account> findAllAccount();
    Account findAccountById(Integer id);
    void saveAccount(Account account);
    void deleteAccount(Integer id);
    void updateAccount(Account account);
}
