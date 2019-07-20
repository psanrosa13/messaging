package com.demo.messaging.demoMessaging.consumidor;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import com.demo.messaging.demoMessaging.model.Mensagem;

@Component
public class ConsumidorTopico {
	
	@Value("${spring.activemq.topic.mensagem}")
	private String topico;
	
	@Autowired
	@Qualifier("jmsTemplateTopic")
	private JmsTemplate jmsTemplateTopico;
	
	public void consumirMensagemTopicoSincrono() throws JMSException {
		TextMessage mensagem = (TextMessage) jmsTemplateTopico.receive("topico.sincrono");
		System.out.println("TOPICO mensagem SINCRONO > "+ mensagem.getText());
	}

	@JmsListener(destination = "topico.mensagem" ,
					containerFactory = "jmsFactoryTopic",
					selector = "visualizado = false",
					subscription = "consumidor1")
	public void consumirMensagemTopicoComSeletor(Mensagem mensagem) {
		System.out.println("TOPICO SELETOR > "+ mensagem.toString() );
	}
	
	
	@JmsListener(destination = "topico.mensagem" ,
			containerFactory = "jmsFactoryTopic", 
			subscription = "consumidor2")
	@SendTo("${spring.activemq.topic.tranformacao}") 
	public Mensagem consumirMensagemTopicoEenviaParaOutro(Mensagem mensagem) {
		
		System.out.println("TOPICO REDIRECIONADOR > "+ mensagem.toString() );
		
		return mensagem;
	}
	
	
	@JmsListener(destination = "topico.transformacao" ,
			containerFactory = "jmsFactoryTopic",
			subscription = "consumidor1")
	public void consumirMensagemTopicoTransformacao(Mensagem mensagem) {
		System.out.println("TOPICO tranformação > "+ mensagem.toString() );
	}
	
}
