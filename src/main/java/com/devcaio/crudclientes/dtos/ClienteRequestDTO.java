package com.devcaio.crudclientes.dtos;

import com.devcaio.crudclientes.domain.entities.Cliente;

public class ClienteRequestDTO {

	private String nome;
	private String email;

	public ClienteRequestDTO() {
	}

	public ClienteRequestDTO(String nome, String email) {
		this.nome = nome;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Cliente toCliente() {
		Cliente cliente = new Cliente(null, nome, email);
		return cliente;
	}

}
