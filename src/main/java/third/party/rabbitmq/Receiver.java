package third.party.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;

public class Receiver {

    private final static String QUEUE_NAME = "hello";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        /*
        We're about to tell the server to deliver us the messages from the queue.
        Since it will push us messages asynchronously, we provide a callback in the
        form of an object that will buffer the messages until we're ready to use them.
        That is what a DefaultConsumer subclass does.
         */
        Consumer consumer = new DefaultConsumer2(channel);
        /*
        The commented out code below works the same as the above line
        The only difference is the way it is coded and when this class is compiled it
        creates the same:
        - Receiver.class
        - Receiver$1.class
        with an additional:
        - Receiver$DefaultConsumer2.class
        */
//        Consumer consumer = new DefaultConsumer(channel) {
//            @Override
//            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
//                    throws IOException {
//                String message = new String(body, "UTF-8");
//                System.out.println(" [x] Received '" + message + "'");
//            }
//        };
        channel.basicConsume(QUEUE_NAME, true, consumer);
    }

    public static class DefaultConsumer2 extends DefaultConsumer {

        public DefaultConsumer2(Channel channel) {
            super(channel);
        }

        @Override
        public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                throws IOException {
            String message = new String(body, "UTF-8");
            System.out.println(" [x] Received '" + message + "'");
        }
    }
}
