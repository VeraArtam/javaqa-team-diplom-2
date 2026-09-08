package ru.netology.javaqadiplom;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class BankTest {

    Bank manager = new Bank();
    Account from = new Account();
    Account to = new Account();

    @Test
    public void transferTest() {
        from.add(100);
        to.add(50);
        int amount = 10;
        manager.transfer(from, to, amount);
        Assertions.assertEquals(90, from.getBalance());
        Assertions.assertEquals(60, to.getBalance());
    }
}
