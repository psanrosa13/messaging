package com.demo.messaging.demoMessaging.comum;

import javax.jms.JMSException;
import javax.jms.Session;

import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

public class ConversorMensagem implements MessageConverter{

	@Override
	public javax.jms.Message toMessage(Object object, Session session) throws JMSException, MessageConversionException {
		
		return null;
	}

	@Override
	public Object fromMessage(javax.jms.Message message) throws JMSException, MessageConversionException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
