package lijie.learning.itheima.d2.service.impl;

import lijie.learning.itheima.d2.dao.IAccountDao;
import lijie.learning.itheima.d2.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired @Qualifier("dao1")
    private IAccountDao accountDao;
    @PostConstruct
    public void init(){
        System.out.println("init...");
    }
    @PreDestroy
    public void destory(){
        System.out.println("destory..");
    }
    @Override
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
