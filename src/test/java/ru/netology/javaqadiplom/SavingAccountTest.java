package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    SavingAccount account = new SavingAccount(
            2_000,
            1_000,
            10_000,
            5
    );

    SavingAccount account1 = new SavingAccount(
            2_222,
            1_000,
            10_000,
            5
    );

    @Test
    public void  savingAccountTestRiteNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new SavingAccount(2_000,1_000, 10_000, -5));
    }

    @Test
    public void  savingAccountTestInitialBalanceNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new SavingAccount(-2_000,1_000, 10_000, 5));
    }

    @Test
    public void  savingAccountTestMinBalanceNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new SavingAccount(2_000,-1_000, 10_000, 5));
    }

    @Test
    public void  savingAccountTestMaxBalanceNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new SavingAccount(2_000,1_000, -10_000, 5));
    }

    @Test
    public void  savingAccountTestMinBalanceBiggerMaxBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new SavingAccount(2_000,10_000, 1_000, 5));
    }

    @Test
    public void  savingAccountTestInitialBalanceBiggerMaxBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new SavingAccount(20_000,1_000, 10_000, 5));
    }

    @Test
    public void  savingAccountTestInitialBalanceLessMinBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new SavingAccount(500,1_000, 10_000, 5));
    }

    @Test
    public void shouldAddLessThanMaxBalance() {
        account.add(3_000);
        Assertions.assertEquals(2_000 + 3_000, account.getBalance());
    }

    @Test
    public void shouldAddBiggerThanMaxBalance() {
        account.add(9_000);
        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldAddIfAmountEquals0() {
        account.add(0);
        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldAddIfAmountNegative() {
        account.add(-1_000);
        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void payTestIfResaltBalanceNorm() {
        account.pay(500);
        Assertions.assertEquals(2_000 - 500, account.getBalance());
    }

    @Test
    public void payTestIfResaltBalanceLessMinBalance() {
        account.pay(1_500);
        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void payTestIfAmountBiggerBalance() {
        account.pay(3_000);
        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void payTestIfAmountEquals0() {
        account.pay(0);
        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void payTestIfAmountNegative() {
        account.pay(-1_000);
        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void yearChangeTest() {
        Assertions.assertEquals(100, account.yearChange());
    }

    @Test
    public void yearChangeTestIfResaltFraction() {
        Assertions.assertEquals(111, account1.yearChange());
    }
}
