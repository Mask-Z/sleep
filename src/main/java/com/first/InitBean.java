package com.first;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author 周云龙
 * @date 2018/4/3 9:11
 */
public class InitBean {

//    @PostConstruct
    public void init(){
        System.out.println("init...");
    }

//    @PreDestroy
    public void destroy(){
        System.out.println("destroy...");
    }
}
