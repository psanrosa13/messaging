package com.demo.messaging.demoMessaging.comum;

import java.util.Enumeration;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

import com.demo.messaging.demoMessaging.model.Mensagem;

public class ConversorMensagem implements MessageConverter{

	@Override
	public javax.jms.Message toMessage(Object object, Session session) throws JMSException, MessageConversionException {
		Mensagem mensagem = (Mensagem) object;
		TextMessage message = session.createTextMessage();
		message.setBooleanProperty("visualizado", mensagem.isVisualizado());
		message.setText(mensagem.toString());
		
		return message; 
	}

	@Override
	public Object fromMessage(javax.jms.Message message) throws JMSException, MessageConversionException {
		String mensagem = message.getBody(String.class);
		return mensagem;
	}

	

}
