package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CreditAccountTest {

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);

        assertEquals(3_000, account.getBalance());
    }

    @Test
    public void constructorShouldCreateAccountWithValidParameters() {
        CreditAccount account = new CreditAccount(1000, 5000, 15);
        assertEquals(1000, account.getBalance());
        assertEquals(5000, account.getCreditLimit());
        assertEquals(15, account.getRate());
    }

    @Test
    public void constructorShouldThrowExceptionWhenRateIsZeroOrNegative() {
        assertThrows(IllegalArgumentException.class,
                () -> new CreditAccount(0, 5000, 0));
        assertThrows(IllegalArgumentException.class,
                () -> new CreditAccount(0, 5000, -5));
    }

    @Test
    public void constructorShouldThrowExceptionWhenCreditLimitIsNegative() {
        assertThrows(IllegalArgumentException.class,
                () -> new CreditAccount(0, -1000, 15));
    }

    @Test
    public void payShouldDecreaseBalanceWithinCreditLimit() {
        CreditAccount account = new CreditAccount(1000, 5000, 15);
        assertTrue(account.pay(3000));
        assertEquals(-2000, account.getBalance()); // 1000 - 3000 = -2000 (в пределах лимита -5000)
    }

    @Test
    public void payShouldReturnFalseAndNotChangeBalanceWhenExceedsLimit() {
        CreditAccount account = new CreditAccount(1000, 5000, 15);
        int initialBalance = account.getBalance();
        assertFalse(account.pay(7000)); // 1000 - 7000 = -6000, лимит -5000 – превышение
        assertEquals(initialBalance, account.getBalance());
    }

    @Test
    public void payShouldReturnFalseForNegativeOrZeroAmount() {
        CreditAccount account = new CreditAccount(1000, 5000, 15);
        int initialBalance = account.getBalance();
        assertFalse(account.pay(0));
        assertFalse(account.pay(-100));
        assertEquals(initialBalance, account.getBalance());
    }

    @Test
    public void add_shouldIncreaseBalanceByAmount() {
        CreditAccount account = new CreditAccount(1000, 5000, 15);
        assertTrue(account.add(3000));
        assertEquals(4000, account.getBalance()); // 1000 + 3000 = 4000
    }

    @Test
    public void add_shouldReturnFalseForNegativeOrZeroAmount() {
        CreditAccount account = new CreditAccount(1000, 5000, 15);
        int initialBalance = account.getBalance();
        assertFalse(account.add(0));
        assertFalse(account.add(-500));
        assertEquals(initialBalance, account.getBalance());
    }

    @Test
    public void yearChange_shouldCalculateInterestForNegativeBalance() {
        CreditAccount account = new CreditAccount(0, 5000, 15);
        account.pay(200); // баланс = -200
        assertEquals(-30, account.yearChange()); // -200 / 100 * 15 = -30
    }

    @Test
    public void yearChange_shouldReturnZeroForPositiveBalance() {
        CreditAccount account = new CreditAccount(200, 5000, 15);
        assertEquals(0, account.yearChange()); // ожидается 0, а в реализации будет 30 – баг.
    }

    @Test
    public void yearChange_shouldReturnZeroForZeroBalance() {
        CreditAccount account = new CreditAccount(0, 5000, 15);
        assertEquals(0, account.yearChange());
    }
}
