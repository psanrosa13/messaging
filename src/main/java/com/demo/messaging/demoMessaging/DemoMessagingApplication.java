package com.demo.messaging.demoMessaging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
public class DemoMessagingApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoMessagingApplication.class, args);
	}

}
