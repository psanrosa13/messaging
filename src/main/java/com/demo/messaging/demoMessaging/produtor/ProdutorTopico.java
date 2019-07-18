package com.demo.messaging.demoMessaging.produtor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.demo.messaging.demoMessaging.model.Mensagem;

@Component
public class ProdutorTopico {
	
	@Value("${spring.activemq.topic.mensagem}")
	private String topico;
	
	@Autowired
	@Qualifier("jmsTemplateTopic")
	private JmsTemplate jmsTemplateTopico;
	
	
//	public boolean publicar(Mensagem mensagem) {
//		try {
//			this.jmsTemplateTopico.convertAndSend(this.topico, mensagem.toString());
//		}catch (Exception e) {
//			return false;
//		}
//		return true;
//	}
	
	public boolean publicar(Mensagem mensagem) {
		try {
			this.jmsTemplateTopico.convertAndSend(this.topico, mensagem.toString());
		}catch (Exception e) {
			return false;
		}
		return true;
	}

}
