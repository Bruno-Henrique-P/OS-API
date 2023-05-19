package com.bruno.OS.domain.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import com.bruno.OS.domain.OS;
import com.bruno.OS.domain.enuns.Prioridade;
import com.bruno.OS.domain.enuns.Status;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotEmpty;


	public class OsDTO implements Serializable {
		private static final long serialVersionUID = 1L;

		
		private Integer id;
		

		private LocalDateTime DataAbertura;
		
		private LocalDateTime DataFechamento;
		
		@NotEmpty(message = "O campo OBSERVAÇÕES é obrigatorio")
		private String Observacoes;
		private Integer status;
		private Integer prioridade;
		private Integer Tecnico;
		private Integer Cliente;
		
		public OsDTO() {
			super();
			// TODO Auto-generated constructor stub
		}

		public OsDTO(OS obj) {
			super();
			this.id = obj.getId();
			this.setDataAbertura(obj.getDataAbertura());
			this.setDataFechamento(obj.getDataFechamento());
			this.Observacoes = obj.getObservcoes();
			this.status = obj.getStatus().getCod();
			this.prioridade = obj.getPrioridade().getCod();
			this.Tecnico = obj.getTecnico().getId();
			this.Cliente = obj.getCliente().getId();
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

		public void setDataFechamento(LocalDateTime dataFechamento) {
			DataFechamento = dataFechamento;
		}

		public Prioridade getPrioridade() {
			return Prioridade.toEnum(this.prioridade);
		}

		public void setPrioridade(Prioridade prioridade) {
			this.prioridade = prioridade.getCod();
		}

		public String getObservcoes() {
			return Observacoes;
		}

		public void setObservcoes(String observcoes) {
			this.Observacoes = observcoes;
		}

		public Status getStatus() {
			return Status.toEnum(this.status);
		}

		public void setStatus(Status status) {
			this.status = status.getCod();
		}

		public Integer getTecnico() {
			return Tecnico;
		}

		public void setTecnico(Integer Tecnico) {
			this.Tecnico = Tecnico;
		}

		public Integer getCliente() {
			return Cliente;
		}

		public void setCliente(Integer Cliente) {
			this.Cliente = Cliente;
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
			OsDTO other = (OsDTO) obj;
			return Objects.equals(id, other.id);
		}
		
		
		
		
	}


