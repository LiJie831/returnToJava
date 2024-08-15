package lijie.learning.itheima.d1.exp2.dao.impl;

import lijie.learning.itheima.d1.exp2.dao.IAccountDao;

//账户的持久层实现类
public class AccountDaoImpl implements IAccountDao {
    public void saveAccount(){
        System.out.println("账户的持久层实现类 存储用户成功");
    }
}
