package com.upskill.multithreading.bank;

public class BankDeposit implements Runnable{
    private Account acc;
    private int deposit;

    public BankDeposit(Account acc, int deposit) {
        this.acc = acc;
        this.deposit = deposit;
    }



    @Override
    public void run() {
      acc.depositAmount(deposit);
        System.out.println("Deposit "+deposit+"="+acc.getBalanceAmount());

    }
}
