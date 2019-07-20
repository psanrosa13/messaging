package com.demo.messaging.demoMessaging.handler;

import org.springframework.util.ErrorHandler;

public class DefaultErrorHandler implements ErrorHandler{

	@Override
	public void handleError(Throwable t) {
		System.out.println("Erro!!!!!!!!!!!!!" + t.getStackTrace());
	}

}
