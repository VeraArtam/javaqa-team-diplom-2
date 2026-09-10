package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class BankTest {

    Bank manager = new Bank();
    Account from = new Account();
    Account to = new Account();

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

//    @Test
//    public void transferTestIfParameterForFromNegative() {
//        from.add(-100);
//        to.add(50);
//        int amount = 10;
//        manager.transfer(from, to, amount);
//        Assertions.assertEquals(0, from.getBalance());
//        Assertions.assertEquals(50, to.getBalance());
//    }

//    @Test
//    public void transferTestIfParameterForToNegative() {
//        from.add(100);
//        to.add(-50);
//        int amount = 10;
//        manager.transfer(from, to, amount);
//        Assertions.assertEquals(90, from.getBalance());
//        Assertions.assertEquals(10, to.getBalance());
//    }

    @Test
    public void transferTestIfAmountBiggerBalanceFrom() {
        from.add(10);
        to.add(50);
        int amount = 100;
        manager.transfer(from, to, amount);
        Assertions.assertEquals(10, from.getBalance());
        Assertions.assertEquals(50, to.getBalance());
    }
}
