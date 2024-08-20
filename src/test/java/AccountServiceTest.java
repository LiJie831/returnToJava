import lijie.learning.config.MajorConfig;
import lijie.learning.itheima.d2.domain.Account;
import lijie.learning.itheima.d2.service.IAccountService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * use junit
 */
@RunWith(SpringJUnit4ClassRunner.class)//换成能创建容器的main方法
@ContextConfiguration(classes = MajorConfig.class)//何种方式创建容器
public class AccountServiceTest {
    @Autowired
    private IAccountService as;
    @Test
    public void testFindAll(){
        List<Account> lst = as.findAllAccount();
        for(Account account:lst){
            System.out.println(account);
        }
    }
    @Test
    public void testFindOne(){
        Account account = as.findAccountById(1);
        System.out.println(account);
    }
    @Test
    public void testSave(){
        Account account = new Account();
        account.setName("test");
        account.setMoney(9F);
        as.saveAccount(account);

    }
    @Test
    public void testDelete(){
        Account account = as.findAccountById(5);
        if(account!=null){
            as.deleteAccount(5);
        }
        account=as.findAccountById(5);
        assert account==null;
    }
    @Test
    public void testUpdate(){

    }
    @Test
    public void mockAndSpy(){
        // mock 会让所有方法都失效
        List<String> mockList = mock(List.class);
        when(mockList.size()).thenReturn(100);
        mockList.add("A");
        Assert.assertNull(mockList.get(0));
        Assert.assertEquals("期望为100",100,mockList.size());

        //spy只会让
        List<String> mockList1 = spy(new ArrayList<>());
        when(mockList1.size()).thenReturn(101);
        mockList1.add("A");
        Assert.assertEquals("期望为A","A",mockList1.get(0));
        Assert.assertEquals("期望为101",101,mockList1.size());

    }
    @Test
    public void testExpectedBehavior(){
        List listMock = mock(List.class);
        listMock.add("3asd");
        listMock.get(0);
        //验证add("3asd")和get(0)行为至少发生一次
        verify(listMock).add("3asd");
        verify(listMock).get(0);
    }
    @Test
    public void testExpectedResult(){
        Iterator mock = mock(Iterator.class);
        //预设置: 当iterator调用next()时第一次返回hello，第n次都返回world
        when(mock.next()).thenReturn("hello").thenReturn("world");
        String res = mock.next()+" "+mock.next()+" "+mock.next();
        org.springframework.util.Assert.isTrue(res.equals("hello world world"),"not expect results");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testExpectedException()throws IOException{
        OutputStream outputStream = mock(OutputStream.class);
        // 预配置:当执行close()时,抛出IllegalArgumentException
        doThrow(new IllegalArgumentException()).when(outputStream).close();
        outputStream.close();

        List mockList = mock(List.class);
        doThrow(new IllegalArgumentException()).when(mockList).add(1);
        mockList.add(1);
    }
}
