package com.first.lock;

/**
 * @author 周云龙
 * @date 2018/5/18 15:35
 */
public class SynchronizeCase extends Thread{
    /**
     * 同步机制是通过对象锁来实现的,1.同步时锁住的是同一个对象,2.锁住访问的静态方法(因为无论有多少类实例,该类的静态方法只有一个)
     */
    @Override
    public  void run() {
        String lock = "lock";
        synchronized (lock) {
            for (int i = 1; i < 10; i++) {
                System.out.print(i);
            }
            System.out.println("-----------");
        }
    }

    public static void main(String[] args) {
        for (int i=0;i<10;i++){
            new SynchronizeCase().start();   
        }
    }
}
