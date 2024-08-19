package lijie.learning.itheima.d2.dao.impl;

import lijie.learning.itheima.d2.dao.IAccountDao;
import org.springframework.stereotype.Repository;

//账户的持久层实现类
@Repository("dao1")
public class AccountDaoImpl implements IAccountDao {
    private int i=0;
    public void saveAccount(){
        i++;
        System.out.println("账户的持久层实现类 存储用户成功+"+i);

    }
}
