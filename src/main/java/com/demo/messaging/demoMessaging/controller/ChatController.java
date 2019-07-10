package com.demo.messaging.demoMessaging.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.messaging.demoMessaging.model.Mensagem;
import com.demo.messaging.demoMessaging.model.Status;
import com.demo.messaging.demoMessaging.service.ChatService;

@Controller("/mensagem")
public class ChatController {

	@Autowired
	ChatService pedidoService;
	
	@PostMapping
	public @ResponseBody Status pedido(@RequestBody Mensagem mensagem) {
		return pedidoService.incluirMensagem(mensagem);
	}
	
}
