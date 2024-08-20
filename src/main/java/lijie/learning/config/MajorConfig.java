package lijie.learning.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * This configuration class has the same effect as bean.xml
 */
@Configuration
//@ComponentScan({"lijie.learning.itheima.d2","lijie.learning.config"})//此时需要在子配置类加上@Configuration注解
@ComponentScan({"lijie.learning.itheima.d2"})
@PropertySource("classpath:jdbcConfig.properties")//因为编译以后，该文件就放在target/classes目录里了
@Import(JDBCConfig.class)
public class MajorConfig {

}
