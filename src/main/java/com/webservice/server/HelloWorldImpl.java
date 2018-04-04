package com.webservice.server;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author 周云龙
 * @date 2018/4/4 10:18
 */
@WebService
public class HelloWorldImpl implements HelloWorldWS {
    @WebMethod
    @Override
    public String sayHello(String name) {
        System.out.println(name + ", Hello World!");
        return name + ", Hello World!";
    }
}
