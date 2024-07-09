package com.syslog.demo.flume;

import org.apache.flume.Event;
import org.apache.flume.EventDeliveryException;
import org.apache.flume.api.RpcClient;
import org.apache.flume.api.RpcClientFactory;
import org.apache.flume.event.EventBuilder;
import java.nio.charset.Charset;

public class FlumeClient {

    public static void main(String[] args) throws EventDeliveryException {
        RpcClient client = RpcClientFactory.getDefaultInstance("192.168.179.128", 44444);
        Event event = EventBuilder.withBody("你好！！！", Charset.forName("UTF-8"));
        client.append(event);
        client.close();
    }

}
