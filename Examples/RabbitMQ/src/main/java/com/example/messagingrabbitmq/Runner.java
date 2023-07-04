package com.example.messagingrabbitmq;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

	private final RabbitTemplate rabbitTemplate;
	private final Receiver receiver;
	private final String message = "Hello from RabbitMQ!";
	private final String routingKey = "foo.bar.baz";

	public Runner(Receiver receiver, RabbitTemplate rabbitTemplate) {
		this.receiver = receiver;
		this.rabbitTemplate = rabbitTemplate;
	}

	private String getMessage(){
		return message;
	}

	private String getRoutingKey(){
		return routingKey;
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Sending message..." + Instant.now());
		sendMessage(MessagingRabbitmqApplication.topicExchangeName, getRoutingKey(), getMessage());
		receiver.getLatch().await(10, TimeUnit.SECONDS);
	}

	private void sendMessage(String topic, String routingKey, Object message){
		rabbitTemplate.convertAndSend(topic, routingKey, message);
	}

}
