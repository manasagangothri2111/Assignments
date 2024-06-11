package com.upskill.multithreading.bank;

public class Transaction {
    public static void main(String[] args) {
        //Depositing amount to the account
        Account acc = new Account(1000);
        System.out.println("Initial Balance: "+acc.getBalanceAmount());
        BankDeposit bd = new BankDeposit(acc,100);
        bd.run();
        System.out.println("Balance1: "+acc.getBalanceAmount());
        BankWithdraw withdraw = new BankWithdraw(acc,300);
        withdraw.run();
        System.out.println("Balance2: "+acc.getBalanceAmount());
        BankDeposit bd1 = new BankDeposit(acc,100);
        bd.run();
        System.out.println("Balance3: "+acc.getBalanceAmount());
        BankWithdraw withdraw1 = new BankWithdraw(acc,300);
        withdraw.run();
        System.out.println("Balance4: "+acc.getBalanceAmount());
        BankDeposit bd2= new BankDeposit(acc,100);
        bd.run();
        System.out.println("Balance5: "+acc.getBalanceAmount());
        BankWithdraw withdraw2 = new BankWithdraw(acc,300);
        withdraw.run();
        System.out.println("Final Balance: "+acc.getBalanceAmount());
    }
    }
