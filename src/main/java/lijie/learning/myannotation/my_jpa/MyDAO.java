//package lijie.learning.myannotation.my_jpa;
//
//import org.apache.commons.dbcp.BasicDataSource;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import java.lang.reflect.Field;
//import java.lang.reflect.ParameterizedType;
//import java.util.ArrayList;
//
//public class MyDAO<T>{
//    private static BasicDataSource dataSource;
//    static {
//        dataSource = new BasicDataSource();
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/lijie_test");
//        dataSource.setUsername("root");
//        dataSource.setPassword("root1234");
//    }
//    private JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//    private Class<T> beanClass;
//
//    public MyDAO(){
//        beanClass =(Class<T>) ((ParameterizedType)this.getClass()
//                .getGenericSuperclass())
//                .getActualTypeArguments()[0];
//
//    }
//
//    public void add(T bean){
//        // 拼接sql
//        Field[] fields = beanClass.getDeclaredFields();
//        StringBuilder sql = new StringBuilder()
//                .append("insert into ")
//                .append(beanClass.getSimpleName())
//                .append(" values(");
//        for(int i=0;i<fields.length-1;i++){
//            sql.append("?");
//            if(i< fields.length-1){
//                sql.append(",");
//            }
//        }
//        sql.append(")");
//
//        //bean对象每个字段对应的值
//        ArrayList<Object> params = new ArrayList<>();
//        try {
//            for (Field f : fields) {
//                f.setAccessible(true);
//                Object o = f.get(bean);
//                params.add(o);
//
//            }
//        }catch (IllegalAccessException e){
//            e.printStackTrace();
//        }
//        Object[] arrParam = params.toArray(new Object[params.size()]);
//        int sqlResNum = jdbcTemplate.update(sql.toString(), arrParam);
//        System.out.println("影响行数: "+sqlResNum);
//    }
//}
