package com.meituan.thrift.service.impl;

import com.meituan.thrift.service.GreetingService;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GreetingServiceImpl implements GreetingService.Iface {
    private static final Logger logger = LoggerFactory.getLogger(GreetingServiceImpl.class);

    public String sayHello(String name) throws TException {
        logger.info(String.format("调用sayHello方法的参数name = {%s}", name));
        return "Hello, " + name;
    }
}
