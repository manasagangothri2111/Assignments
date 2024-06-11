package com.upskill.multithreading.bank;

public class Account {
    private int BalanceAmount;
    public Account(int balanceAmount) {
        BalanceAmount = balanceAmount;
    }
    public int getBalanceAmount() {
        return BalanceAmount;
    }

    public void setBalanceAmount(int balanceAmount) {
        BalanceAmount = balanceAmount;
    }
    synchronized public int depositAmount(int amount) {

        return BalanceAmount=BalanceAmount+amount;
    }

     synchronized int withdrawAmount(int amount) {
       return BalanceAmount=BalanceAmount-amount;
    }

}
