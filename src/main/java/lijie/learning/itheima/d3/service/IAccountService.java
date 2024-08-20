package lijie.learning.itheima.d3.service;

import lijie.learning.itheima.d3.domain.Account;

import java.util.List;

public interface IAccountService {
    List<Account> findAllAccount();
    Account findAccountById(Integer id);
    void saveAccount(Account account);
    void deleteAccount(Integer id);
    void updateAccount(Account account);
    /**
     * 转账
     * @param sourceName 转出账户名称
     * @param targetName 转入账户名称
     * @param money 转账金额
     */
    void transfer(String sourceName,String targetName,Float money);
}
