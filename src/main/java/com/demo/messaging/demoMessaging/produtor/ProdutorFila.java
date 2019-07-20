package com.demo.messaging.demoMessaging.produtor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.demo.messaging.demoMessaging.model.Mensagem;

@Service
public class ProdutorFila {
	
	@Value("${spring.activemq.queue.mensagem}")
	private String fila;
	
	@Autowired
	@Qualifier("jmsTemplateQueue")
	private JmsTemplate jmsTemplate;

	public void publicar(Mensagem mensagem) {
		this.jmsTemplate.convertAndSend(fila, mensagem);
		this.jmsTemplate.convertAndSend("fila.filtro", mensagem);
	}
	
}
