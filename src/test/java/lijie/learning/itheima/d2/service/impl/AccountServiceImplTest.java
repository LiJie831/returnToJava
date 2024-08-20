package lijie.learning.itheima.d2.service.impl;

import lijie.learning.itheima.d2.dao.IAccountDao;
import lijie.learning.itheima.d2.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)//这样的话 @Mock 对象才不报空指针(才能从容器中获取到bean)跟 @autowired 类似
public class AccountServiceImplTest {

    @Mock// 配合@RunWith(MockitoJUnitRunner.class)一起使用才不会报空指针异常
    private IAccountDao mockAccountDao;

    @InjectMocks
    private AccountServiceImpl accountServiceImplUnderTest;

    @Test
    public void testFindAllAccount() {
        // Setup
        // Configure IAccountDao.findAllAccount(...).
        final Account account = new Account();
        account.setName("name1");
        account.setId(1);
        account.setMoney(1.0f);
        final Account account1 = new Account();
        account1.setName("name2");
        account1.setId(2);
        account1.setMoney(2.2f);
        final List<Account> accounts = Arrays.asList(account, account1);
        when(mockAccountDao.findAllAccount()).thenReturn(accounts);

        // Run the test
        final List<Account> result = accountServiceImplUnderTest.findAllAccount();
        // Verify the results
        Assert.isTrue(result.size()==2,"expect 2 accounts");
    }

    @Test
    public void testFindAllAccount_IAccountDaoReturnsNoItems() {
        // Setup
        when(mockAccountDao.findAllAccount()).thenReturn(Collections.emptyList());

        // Run the test
        final List<Account> result = accountServiceImplUnderTest.findAllAccount();

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testFindAccountById() {
        // Setup
        // Configure IAccountDao.findAccountById(...).
        final Account account = new Account();
        account.setName("name");
        account.setId(1);
        account.setMoney(0.0f);
        when(mockAccountDao.findAccountById(1)).thenReturn(account);

        // Run the test
        final Account result = accountServiceImplUnderTest.findAccountById(1);

        // Verify the results
        Assert.isTrue(result.getId()==1,"expected account's id is 1!");
    }

    @Test
    public void testSaveAccount() {
        // Setup
        final Account account = new Account();
        account.setName("name");
        account.setId(0);
        account.setMoney(0.0f);

        // Run the test
        accountServiceImplUnderTest.saveAccount(account);

        // Verify the results
        verify(mockAccountDao).saveAccount(any(Account.class));
    }

    @Test
    public void testDeleteAccount() {
        // Setup
        // Run the test
        accountServiceImplUnderTest.deleteAccount(0);

        // Verify the results
        // 也就是说当上面那条代码调用时,检验dao的deleteAccount(0)行为至少发生了1次
        verify(mockAccountDao).deleteAccount(0);
    }

    @Test
    public void testUpdateAccount() {
        // Setup
        final Account account = new Account();
        account.setName("name");
        account.setId(0);
        account.setMoney(0.0f);

        // Run the test
        accountServiceImplUnderTest.updateAccount(account);

        // Verify the results
        verify(mockAccountDao).updateAccount(any(Account.class));
    }
}
