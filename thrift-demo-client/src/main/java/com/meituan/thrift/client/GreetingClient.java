package com.meituan.thrift.client;

import com.meituan.thrift.service.GreetingService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GreetingClient {
//    private static final Logger logger = LoggerFactory.getLogger(GreetingClient.class);

    public static void main(String[] args) {
        try {
            TTransport transport = new TSocket("127.0.0.1", 9090, 30000);
            TProtocol protocol = new TBinaryProtocol(transport);

            GreetingService.Client client = new GreetingService.Client(protocol);
            transport.open();

            String name = "Eric";
            System.out.println("请求参数==>name为" + name);
            String result = client.sayHello("Eric");
            System.out.println("返回结果==>为" + result);
            transport.close();
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        }
    }
}
