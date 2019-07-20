package com.demo.messaging.demoMessaging.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.messaging.demoMessaging.model.Mensagem;
import com.demo.messaging.demoMessaging.model.Status;
import com.demo.messaging.demoMessaging.service.ChatService;

@Controller
@RequestMapping("/mensagem")
public class ChatController {

	@Autowired
	ChatService pedidoService;
	
	@PostMapping("/fila")
	public @ResponseBody Status mensagemFila(@RequestBody Mensagem mensagem) {
		return pedidoService.incluirMensagemFila(mensagem);
	}
	
	@PostMapping("/topico")
	public @ResponseBody Status mensagemTopico(@RequestBody Mensagem mensagem) {
		return pedidoService.incluirMensagemTopico(mensagem);
	}
	
}
