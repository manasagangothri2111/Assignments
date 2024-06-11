package com.upskill.multithreading.bank;

public class BankWithdraw implements Runnable {
    private Account acc;
    private int withdraw;

    public BankWithdraw(Account acc, int withdraw) {
        this.acc = acc;
        this.withdraw =withdraw;
    }

    @Override
    public void run() {
       acc.withdrawAmount(withdraw);
       System.out.println("Withdraw "+withdraw+"="+acc.getBalanceAmount());
    }

}
