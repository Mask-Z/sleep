package com.first;

import org.junit.Test;

/**
 * 死锁
 * @author 周云龙
 * @date 2018/4/3 15:00
 */
public class DeadThread {
    private static final String A = "A";
    private static final String B = "B";

    @Test
    public void fun(){
//        Runnable thread1 = new Thread1();
//        Runnable thread2 = new Thread2();
//        new Thread(thread1).start();
//        new Thread(thread2).start();

        new Thread(()->{
            synchronized (A){
                System.out.println(11111);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (B){
                    System.out.println(22222);
                }
            }
        }).start();
        new Thread(()->{
            synchronized(B){
                System.out.println(33333);
                synchronized (A){
                    System.out.println(44444);
                }
            }
        }).start();
    }
    class Thread1 implements Runnable{

        @Override
        public void run() {
            synchronized (A){
                try {
                    System.out.println(11111);
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (B){
                    System.out.println(22222);
                }
            }
        }
    }

    class Thread2 implements Runnable{

        @Override
        public void run() {
            synchronized(B){
                System.out.println(33333);
                synchronized (A){
                    System.out.println(44444);
                }
            }
        }
    }
}
