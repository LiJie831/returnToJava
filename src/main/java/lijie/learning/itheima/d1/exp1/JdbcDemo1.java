package lijie.learning.itheima.d1.exp1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcDemo1 {
    public static void main(String[] args) throws Exception{
        //1注册驱动
//        DriverManager.registerDriver(new com.mysql.jdbc.Driver());//new 导致严重依赖
        Class.forName("com.mysql.jdbc.Driver");//硬编码
//        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lijie_test","root","Root1234!");
        PreparedStatement pstm = conn.prepareStatement("select * from account");
        ResultSet res = pstm.executeQuery();
        while (res.next()){
            System.out.println(res.getString("name"));
        }
        res.close();
        pstm.close();
        conn.close();
    }
}
