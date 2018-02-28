package com.activemq.sender;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class MessageSender {
    private static String url = "tcp://192.168.99.100:32768";
    private static String subject = "JCG_QUEUE";

    public static void main(String[] args) throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        Connection connection = connectionFactory.createConnection();

        connection.start();
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue(subject);
        MessageProducer producer = session.createProducer(destination);
        TextMessage message = session.createTextMessage("Hello !!! Welcome to the world of ←- ActiveMQ.");
        producer.send(message);
        System.out.println("JCG printing@@ ’" + message.getText() + "’");
        connection.close();
    }
}
