package com.bruno.OS.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import com.bruno.OS.domain.enuns.Prioridade;
import com.bruno.OS.domain.enuns.Status;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class OS implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime DataAbertura;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime DataFechamento;
	
	private Prioridade prioridade;
	private String Observacoes;
	private Status status;
	
	
	@ManyToOne
	@JoinColumn(name = "tecnico_id")
	private Tecnico tecnico;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	public OS() {
		super();
		this.setDataAbertura(LocalDateTime.now());
		this.setPrioridade(Prioridade.BAIXA);
		this.setStatus(Status.ABERTO);
		// TODO Auto-generated constructor stub
	}

	public OS(Integer id, Prioridade prioridade,
			String Observacoes, Status status, Tecnico tecnico, Cliente cliente) {
		super();
		this.id = id;
		this.setDataAbertura(LocalDateTime.now());
		this.prioridade = (prioridade == null) ? Prioridade.BAIXA : Prioridade.toEnum(prioridade.getCod());
		this.Observacoes = Observacoes;
		this.status = (status == null) ? Status.ABERTO : Status.toEnum(status.getCod());
		this.tecnico = tecnico;
		this.cliente = cliente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDataAbertura() {
		return DataAbertura;
	}

	public void setDataAbertura(LocalDateTime dataAbertura) {
		this.DataAbertura = dataAbertura;
	}
	
	public LocalDateTime getDataFechamento() {
		return DataFechamento;
	}

	public void setDataFechamento(LocalDateTime DataFechamento) {
		this.DataFechamento = DataFechamento;
	}


	public Prioridade getPrioridade() {
		return this.prioridade;
	}

	public void setPrioridade(Prioridade prioridade) {
		this.prioridade = prioridade;
	}

	public String getObservcoes() {
		return Observacoes;
	}

	public void setObservcoes(String observcoes) {
		this.Observacoes = observcoes;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OS other = (OS) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
}
