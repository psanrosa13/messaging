package com.demo.messaging.demoMessaging.consumidor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class ConsumidorTopico {

//	@JmsListener(destination = "topico.mensagem" , containerFactory = "jmsFactoryTopic")
//	public void consumirMensagemTopico(String mensagem) {
//		System.out.println("TOPICO"+ mensagem );
//	}
	
	@JmsListener(destination = "topico.mensagem" ,
					containerFactory = "jmsFactoryTopic",
					selector = "visualizado = false")
	public void consumirMensagemTopico(String mensagem) {
		System.out.println("TOPICO"+ mensagem );
	}
	
//	@JmsListener(destination = "topico.mensagem" , containerFactory = "jmsFactoryTopic")
//	@SendTo("${spring.activemq.topic.tranformacao}") 
//	public Message<String> consumirMensagemTopico(Message mensagem) {
//		System.out.println("TOPICO"+ mensagem.getHeaders() );
//		
//		return MessageBuilder              
//                .withPayload(mensagem.getPayload().toString())
//                .setHeader("ID", UUID.randomUUID().toString())
//                .setHeader("DATE",
//                       new SimpleDateFormat("yyyy-MM-dd")
//                               .format(new Date()))
//                .build();
//	}
	
	@JmsListener(destination = "topico.transformacao" , containerFactory = "jmsFactoryTopic")
	public void consumirMensagemTopicoTransformacao(Message mensagem) {
		System.out.println("TOPICO tranformação:"+ mensagem.getPayload() );
	}
	
}
