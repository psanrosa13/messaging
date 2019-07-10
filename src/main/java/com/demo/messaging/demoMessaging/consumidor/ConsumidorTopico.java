package com.demo.messaging.demoMessaging.consumidor;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumidorTopico {

	@JmsListener(destination = "topico.mensagem" , containerFactory = "jmsFactoryTopic")
	public void consumirMensagemTopico(String mensagem) {
		System.out.println("TOPICO"+ mensagem );
	}
	
}
