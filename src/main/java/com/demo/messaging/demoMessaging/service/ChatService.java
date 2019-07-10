package com.demo.messaging.demoMessaging.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.messaging.demoMessaging.model.Mensagem;
import com.demo.messaging.demoMessaging.model.Status;
import com.demo.messaging.demoMessaging.produtor.ProdutorFila;
import com.demo.messaging.demoMessaging.produtor.ProdutorTopico;

@Service
public class ChatService {
	
	@Autowired
	ProdutorFila produtorFila;

	@Autowired
	ProdutorTopico produtorTopico;
	
	
	public Status incluirMensagem(Mensagem mensagem) {
		
		if (produtorFila.publicar(mensagem) && 
				produtorTopico.publicar(mensagem)) {
			return new Status("AGUARDANDO CONFIRMAÇÃO","Seu pedido foi encaminhado para o fornecedor");
		}else {
			return new Status("ERRO","Houve um problema ao solicitar seu pedido");
		}
	}

}
