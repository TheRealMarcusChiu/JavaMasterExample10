https://www.rabbitmq.com/tutorials/tutorial-one-java.html

Make Sure you have RabbitMQ server running on your local machine with default configuration

Sender.java   - produces a message "Hello World!" and sends it to the RabbitMQ which will be queued into the "hello" queue
Receiver.java - waits and consumes a message within the "hello" queue and prints out the message "Hello World!"

## IntelliJ Execution

1. run Receiver.java
2. run Sender.java

## Terminal Execution (DOES NOT WORK)

1. compile both Sender.java and Receiver.java
   javac -cp /Users/marcuschiu/.m2/repository/com/rabbitmq/amqp-client/5.5.1/amqp-client-5.5.1.jar Sender.java Receiver.java -d .

2. run receiver
   java -cp .:amqp-client-5.5.1.jar:slf4j-api-1.6.6.jar:slf4j-simple-1.6.1.jar third.party.rabbitmq.Receiver

3. run sender
   java -cp .:amqp-client-5.5.1.jar:slf4j-api-1.6.6.jar:slf4j-simple-1.6.1.jar third.party.rabbitmq.Sender