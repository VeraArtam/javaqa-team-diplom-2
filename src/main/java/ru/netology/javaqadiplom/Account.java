package ru.netology.javaqadiplom;

public class Account {
    protected int balance;
    protected int rate;

    public boolean pay(int amount) {
        if (amount > 0) {
            if (balance >= amount) {
                balance -= amount;
                return true;
            }
        }
        return false;
    }

    public boolean add(int amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    public int yearChange() {
        return 0;
    }

    public int getBalance() {
        return balance;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
