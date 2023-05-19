package com.bruno.OS.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

import java.io.Serializable;

@Entity
public class Cliente extends Pessoa implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "cliente")
	private List<OS> list  = new ArrayList<>();
	
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cliente(Integer id, String nome, String cpf, String telefone) {
		super(id, nome, cpf, telefone);
		// TODO Auto-generated constructor stub
	}

	public List<OS> getList() {
		return list;
	}

	public void setList(List<OS> list) {
		this.list = list;
	}
	
	
	
	
}
