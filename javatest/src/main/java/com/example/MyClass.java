package com.example;


//http://blog.csdn.net/xuxurui007/article/details/7685076
public class MyClass {
    public static void main(String args[]){

        System.out.println("java Test");
        new MyThread1().start();
        MyThread2 myThread2 = new MyThread2();
        new Thread(myThread2).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("MyThread3");
            }
        });
    }


    static class MyThread1 extends Thread{
        @Override
        public void run() {
            System.out.println("MyThread1");
        }
    }

    static class MyThread2 implements Runnable{
        @Override
        public void run() {
            System.out.println("MyThread2");
        }
    }

}
