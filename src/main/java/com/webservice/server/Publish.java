package com.webservice.server;

import javax.xml.ws.Endpoint;

/**
 * @author 周云龙
 * @date 2018/4/4 10:23
 */
public class Publish {
    public static void main(String[] args) {
        Object implementor = new HelloWorldImpl();
        String address = "http://localhost:8080/HelloWorld";
        Endpoint.publish(address,implementor);
        System.out.println("发布成功");
    }
}
