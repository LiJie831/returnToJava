package lijie.learning.itheima.d2.ui;

import lijie.learning.itheima.d2.service.IAccountService;
import lijie.learning.itheima.d2.service.impl.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//模拟表现层用于调用业务层
public class Client {
    public static void main(String[] args) {
//        IAccountService service = new AccountServiceImpl();//这个new 要避免！！！
//        IAccountService service = (IAccountService)BeanFactory.getBean("accountService");//get bean from my factory
        // get bean from spring framework
        //1.获取核心容器对象
        ClassPathXmlApplicationContext ac= new ClassPathXmlApplicationContext("bean_d2.xml");
        //2.根据id获取bean对象
//        IAccountService service = (IAccountService)ac.getBean("accountService");
        IAccountService service = ac.getBean("accountServiceImpl", IAccountService.class);
        service.saveAccount();
        ac.close();
    }
}
