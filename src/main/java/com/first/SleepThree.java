package com.first;

/**
 * @author 周云龙
 * @date 2018/3/30 14:00
 */
public class SleepThree {
    private int i;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public void print(){
        System.out.println("i: "+ i);
        i++;
    }
}
