package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class BankTest {

    Bank manager = new Bank();
    Account from = new Account();
    Account to = new Account();
//    Account repo = Mockito.mock(Account.class);

    @Test
    public void transferTestIfParametersValid() {
        from.add(100);
        to.add(50);
        int amount = 10;
        manager.transfer(from, to, amount);
        Assertions.assertEquals(90, from.getBalance());
        Assertions.assertEquals(60, to.getBalance());
    }

    @Test
    public void transferTestIfAmountNegative() {
        from.add(100);
        to.add(50);
        int amount = -10;
        manager.transfer(from, to, amount);
        Assertions.assertEquals(100, from.getBalance());
        Assertions.assertEquals(50, to.getBalance());
    }

    @Test
    public void transferTestIfAmountEquals0() {
        from.add(100);
        to.add(50);
        int amount = 0;
        manager.transfer(from, to, amount);
        Assertions.assertEquals(100, from.getBalance());
        Assertions.assertEquals(50, to.getBalance());
    }

    @Test
    public void transferTestIfAmountBiggerBalanceFrom() {
        from.add(10);
        to.add(50);
        int amount = 100;
        manager.transfer(from, to, amount);
        Assertions.assertEquals(10, from.getBalance());
        Assertions.assertEquals(50, to.getBalance());
    }

    @Test
    public void transferTestIfToAddFalse() {
        Account to = Mockito.mock(Account.class);
        doReturn(false).when(to).add(100);
        from.add(200);
        int amount = 100;
        Assertions.assertFalse(manager.transfer(from, to, amount));
    }
}
