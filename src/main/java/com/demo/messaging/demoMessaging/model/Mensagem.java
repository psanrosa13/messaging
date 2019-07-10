package com.demo.messaging.demoMessaging.model;

public class Mensagem {

	private String nome;
	private String mensagem;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	@Override
	public String toString() {
		return "Mensagem [nome=" + nome + ", mensagem=" + mensagem + "]";
	}
	
}
