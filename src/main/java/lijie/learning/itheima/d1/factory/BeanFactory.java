package lijie.learning.itheima.d1.factory;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/*
一个创建bean对象的工厂
 */
public class BeanFactory {
    private static Object bean;
    private static Map<String,Object> beanMap = new HashMap();
    private static Properties props;
    static {
        try {
            props = new Properties();//这个new不能消除
            //
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props.load(in);
        }catch (Exception e){
//            e.printStackTrace();
            throw new ExceptionInInitializerError("初始化properties失败！");
        }

    }

    /**
     *
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName){
        if(beanMap.containsKey(beanName)){
            return beanMap.get(beanName);
        }
        try {
            String beanPath = props.getProperty(beanName);
            bean = Class.forName(beanPath).newInstance();
            beanMap.put(beanName,bean);
        }catch (Exception e){
            e.printStackTrace();
        }
        return bean;
    }
}
