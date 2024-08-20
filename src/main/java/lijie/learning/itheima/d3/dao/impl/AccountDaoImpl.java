package lijie.learning.itheima.d3.dao.impl;

import lijie.learning.itheima.d3.dao.IAccountDao;
import lijie.learning.itheima.d3.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

//账户的持久层实现类
@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {
    @Autowired
    private QueryRunner runner;

    @Override
    public List<Account> findAllAccount() {
        try {
            return runner.query("select * from account",new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account findAccountById(Integer id) {
        try {
            return runner.query("select * from account where id=?",
                    new BeanHandler<Account>(Account.class),
                    id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveAccount(Account account) {
        try {
            runner.update("insert into account(name,money) values(?,?)",account.getName(),account.getMoney());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteAccount(Integer id) {
        try {
            runner.update("delete from account where id=?", id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateAccount(Account account) {
        try {
            runner.update("update account set name=?,money=? where id=?",
                    account.getName(),account.getMoney(),account.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account findAccountByName(String name) {
        List<Account> lstAccount ;
        try {
            lstAccount = runner.query("select * from account where name=?",
                    new BeanListHandler<>(Account.class),
                    name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(lstAccount==null||lstAccount.isEmpty()){
            return null;
        }else if(lstAccount.size()>1){
            throw new RuntimeException(name+" account result set is not unique.");
        }else return lstAccount.get(0);
    }
}
