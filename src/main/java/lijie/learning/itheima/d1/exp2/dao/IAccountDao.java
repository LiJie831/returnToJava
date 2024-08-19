package lijie.learning.itheima.d1.exp2.dao;

import lijie.learning.itheima.d1.exp2.domain.Account;

import java.util.List;

//持久层接口
public interface IAccountDao {

    List<Account> findAllAccount();
    Account findAccountById(Integer id);
    void saveAccount(Account account);
    void deleteAccount(Integer id);
    void updateAccount(Account account);
}
