package com.upskill.multithreading;

public class AssignmentThreads {
    public static void main(String[] args) {
        System.out.println("Example 1");
        ThreadA tA = new ThreadA();
        tA.setName("First Thread");
        tA.start();
        ThreadB tB = new ThreadB();
        tB.setName("Second Thread");
        tB.start();


    }
}

     class ThreadA extends Thread{
        @Override
        public void run(){
            for(int i=1;i<=10;i++){

                System.out.println(Thread.currentThread().getName()+i);
            }

        }
    }
    class ThreadB extends Thread{
        @Override
        public void run(){
            for(int i=1;i<11;i++){

                System.out.println(Thread.currentThread().getName()+i);
            }

        }
    }
