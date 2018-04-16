package com.webservice.test;

import com.webservice.client.HelloWorldImpl;
import com.webservice.client.HelloWorldImplService;
import com.webservice.wsdemo.FixedpriceService;
import com.webservice.wsdemo.FixedpriceService_Service;

/**
 * @author 周云龙
 * @date 2018/4/4 14:04
 */
public class ClientTest {
    public static void main(String[] args) {
        HelloWorldImplService helloWorldImplService=new HelloWorldImplService();
        HelloWorldImpl helloWorld = helloWorldImplService.getHelloWorldImplPort();
        System.out.println(helloWorld.sayHello("Mask-Z"));

        FixedpriceService_Service fixedpriceServiceService=new FixedpriceService_Service();
        FixedpriceService fixedpriceService=fixedpriceServiceService.getFixedpriceWSPort();
    }
}
