package com.first;

import org.junit.Test;

/**
 * 死锁
 *
 * @author 周云龙
 * @date 2018/4/3 15:00
 */
public class DeadThread {
    private static final String A = "A";
    private static final String B = "B";

    @Test
    public void fun() {


        new Thread(() -> {
            synchronized (A) {
                System.out.println(11111);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (B) {
                    System.out.println(22222);
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (B) {
                System.out.println(33333);
                synchronized (A) {
                    System.out.println(44444);
                }
            }
        }).start();

        for (int i=10;i>0;i--)
        new Thread(()-> System.out.println(Thread.currentThread()+".......")).start();
    }

    class Thread1 implements Runnable {

        @Override
        public void run() {
            synchronized (A) {
                try {
                    System.out.println(11111);
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (B) {
                    System.out.println(22222);
                }
            }
        }
    }

    class Thread2 implements Runnable {

        @Override
        public void run() {
            synchronized (B) {
                System.out.println(33333);
                synchronized (A) {
                    System.out.println(44444);
                }
            }
        }
    }
}
