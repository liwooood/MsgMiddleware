package com.cssweb.middleware.rabbitmq;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

import java.io.IOException;

/**
 * Created by chenhf on 14-3-5.
 */
public class RabbitmqTest {
    private final static String QUEUE_NAME = "hello";

    public static void  main(String args[])
    { try {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.1.201");
        Connection connection = null;

            connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        String message = "Hello World!";
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");

        channel.close();
        connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
