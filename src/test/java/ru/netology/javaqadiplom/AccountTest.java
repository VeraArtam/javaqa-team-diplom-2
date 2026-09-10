package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {

    Account account = new Account();

    @Test
    public void addTestAmountValid() {
        account.add(111);
        Assertions.assertEquals(111, account.getBalance());
    }

    @Test
    public void addTestAmountEquals0() {
        account.add(0);
        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void addTestAmountNegative() {
        account.add(-111);
        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void payTestAmountValid() {
        account.add(99);
        account.pay(11);
        Assertions.assertEquals(88, account.getBalance());
    }

    @Test
    public void payTestAmountEquals0() {
        account.add(99);
        account.pay(0);
        Assertions.assertEquals(99, account.getBalance());
    }

    @Test
    public void payTestAmountNegative() {
        account.add(99);
        account.pay(-11);
        Assertions.assertEquals(99, account.getBalance());
    }

    @Test
    public void payTestAmountBiggerBalance() {
        account.add(99);
        account.pay(111);
        Assertions.assertEquals(99, account.getBalance());
    }
}
