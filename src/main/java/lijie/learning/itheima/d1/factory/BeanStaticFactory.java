package lijie.learning.itheima.d1.factory;

import lijie.learning.itheima.d1.exp2.service.IAccountService;
import lijie.learning.itheima.d1.exp2.service.impl.AccountServiceImpl;

public class BeanStaticFactory {
    public static IAccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
