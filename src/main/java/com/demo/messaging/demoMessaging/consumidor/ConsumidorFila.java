package com.demo.messaging.demoMessaging.consumidor;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumidorFila {

	@JmsListener(destination = "fila.mensagem" ,
					containerFactory = "jmsFactoryQueue",
					selector = "" , subscription = "" )
	public void consumirMensagemTopico(String mensagem) {
		System.out.println("FILA"+  mensagem );
	}
}
