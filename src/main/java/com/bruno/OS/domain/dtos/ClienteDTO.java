package com.bruno.OS.domain.dtos;

import java.io.Serializable;

import org.hibernate.validator.constraints.br.CPF;

import com.bruno.OS.domain.Cliente;

public class ClienteDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	
	@CPF
	private String cpf;
	private String telefone;
	
	public ClienteDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClienteDTO(Cliente obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.telefone = obj.getTelefone();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	
	
}
