package com.demo.messaging.demoMessaging.converter;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

import com.demo.messaging.demoMessaging.model.Mensagem;
import com.google.gson.Gson;

public class ConversorMensagem implements MessageConverter{

	@Override
	public Message toMessage(Object object, Session session) throws JMSException, MessageConversionException {
		System.out.println("Entrou na conversão toMessage");
		
		Mensagem mensagem = (Mensagem) object;
		TextMessage message = session.createTextMessage();
		message.setBooleanProperty("visualizado", mensagem.isVisualizado());
		message.setText(new Gson().toJson(mensagem));
		
		System.out.println("Saiu na conversão toMessage");
		return message; 
	}
	


	@Override
	public Object fromMessage(Message message) throws JMSException, MessageConversionException {
		System.out.println("Entrou na conversão fromMessage");
		
		TextMessage textMessage = (TextMessage) message;
		
		String json = textMessage.getText();
		
		Mensagem mensagem = new Gson().fromJson(json,Mensagem.class);
		
		System.out.println("Saiu na conversão fromMessage");
		
		return mensagem;
	}

	

}
