package lijie.learning.itheima.d1.exp2.dao.impl;

import lijie.learning.itheima.d1.exp2.dao.IAccountDao;

import java.util.Date;

//账户的持久层实现类
public class AccountDaoImpl implements IAccountDao {
    private int i=0;
    public void saveAccount(){
        i++;
        System.out.println("账户的持久层实现类 存储用户成功+"+i);

    }
}
