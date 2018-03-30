package com.first;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author 周云龙
 * @date 2018/3/28 19:18
 */
public class SleepTwo implements ApplicationContextAware{

    private ApplicationContext applicationContext;
    private SleepThree sleepThree;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public SleepThree getThree(){
        return this.applicationContext.getBean("sleep3",SleepThree.class);
    }

    public SleepThree getSleepThree() {
        return sleepThree;
    }

    public void setSleepThree(SleepThree sleepThree) {
        this.sleepThree = sleepThree;
    }

    public void print(){
        this.getThree().print();
    }
}
