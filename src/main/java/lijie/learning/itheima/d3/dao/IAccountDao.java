package lijie.learning.itheima.d3.dao;

import lijie.learning.itheima.d3.domain.Account;

import java.util.List;

//持久层接口
public interface IAccountDao {

    List<Account> findAllAccount();
    Account findAccountById(Integer id);
    void saveAccount(Account account);
    void deleteAccount(Integer id);
    void updateAccount(Account account);

    /**
     * query account by name
     * @param name
     * @return account object if only 1 result, or null if no result, or throw exception if multiple accounts.
     */
    Account findAccountByName(String name);
}
