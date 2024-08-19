package lijie.learning.itheima.d1.exp2.service.impl;

import lijie.learning.itheima.d1.exp2.dao.IAccountDao;
import lijie.learning.itheima.d1.exp2.service.IAccountService;
import lijie.learning.itheima.d1.factory.BeanFactory;
import lombok.Setter;

import java.util.Date;


public class AccountServiceImpl implements IAccountService {
//    private IAccountDao accountDao = new AccountDaoImpl();
    @Setter
    private String name;
    @Setter
    private Integer age;
    @Setter
    private Date birthday;
    public AccountServiceImpl(){}
    public AccountServiceImpl(String name, Integer age,Date birthday){
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }
    private IAccountDao accountDao =(IAccountDao)BeanFactory.getBean("accountDao");
    @Override
    public void saveAccount() {
        accountDao.saveAccount();
        System.out.println(name);
        System.out.println(age);
        System.out.println(birthday);
    }
}
