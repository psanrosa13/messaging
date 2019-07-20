package com.demo.messaging.demoMessaging.consumidor;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.demo.messaging.demoMessaging.model.Mensagem;

@Component
public class ConsumidorFila {

	@JmsListener(destination = "fila.mensagem" ,
					containerFactory = "jmsFactoryQueue")
	public void consumirMensagemTopico(Mensagem mensagem) {
		System.out.println("FILA > "+  mensagem.toString() );
	}
	
	@JmsListener(destination = "fila.filtro" ,
			containerFactory = "jmsFactoryQueue",
			selector = "visualizado = false " , subscription = "" )
	public void consumirMensagemTopicoSeletor(Mensagem mensagem) {
		System.out.println("FILA SELETOR > "+  mensagem );
	}
}
