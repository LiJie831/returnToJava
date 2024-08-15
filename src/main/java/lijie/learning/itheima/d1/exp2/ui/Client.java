package lijie.learning.itheima.d1.exp2.ui;

import lijie.learning.itheima.d1.exp2.service.IAccountService;
import lijie.learning.itheima.d1.exp2.service.impl.AccountServiceImpl;

//模拟表现层用于调用业务层
public class Client {
    public static void main(String[] args) {
        IAccountService service = new AccountServiceImpl();//这个new 要避免！！！
        service.saveAccount();
    }
}
