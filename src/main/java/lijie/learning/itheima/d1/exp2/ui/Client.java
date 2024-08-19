package lijie.learning.itheima.d1.exp2.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import lijie.learning.itheima.d1.exp2.service.IAccountService;
//模拟表现层用于调用业务层
public class Client {
    public static void main(String[] args) {
//        IAccountService service = new AccountServiceImpl();//这个new 要避免！！！
//        IAccountService service = (IAccountService)BeanFactory.getBean("accountService");//get bean from my factory
        // get bean from spring framework
        //1.获取核心容器对象
        ApplicationContext ac= new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取bean对象
//        IAccountService service = (IAccountService)ac.getBean("accountService");
        IAccountService service =ac.getBean("accountService2",IAccountService.class);
        service.saveAccount();
    }
}
