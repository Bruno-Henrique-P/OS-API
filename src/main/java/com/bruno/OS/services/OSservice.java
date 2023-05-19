package com.bruno.OS.services;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruno.OS.domain.OS;
import com.bruno.OS.domain.Tecnico;
import com.bruno.OS.domain.Cliente;
import com.bruno.OS.domain.dtos.OsDTO;
import com.bruno.OS.domain.enuns.Prioridade;
import com.bruno.OS.domain.enuns.Status;
import com.bruno.OS.repository.OsRepository;
import com.bruno.OS.services.Exception.ObjectNotFoundException;

import jakarta.validation.Valid;

@Service
public class OSservice {
	
	@Autowired
	private OsRepository repository;
	
	@Autowired
	private TecnicoService tecnicoService;
	
	@Autowired
	private ClienteService clienteService;
	
	public OS findById(Integer id) {
		Optional<OS> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto no encontrado! id: "
				+ id + " ,Tipo: " + OS.class.getName()));
	}
	
	public List<OS> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	public OS create(@Valid OsDTO objDTO) {
		return fromDTOS(objDTO);
	}
	
	public OS uptade( @Valid OsDTO objDTO) {
		OS newobj = findById(objDTO.getId());
		newobj.setId(objDTO.getId());
		newobj.setPrioridade(Prioridade.toEnum(objDTO.getPrioridade().getCod()));
		newobj.setStatus(Status.toEnum(objDTO.getStatus().getCod()));
		newobj.setObservcoes(objDTO.getObservcoes());
		
		Tecnico tec = tecnicoService.findById(objDTO.getTecnico());
		Cliente cli = clienteService.findById(objDTO.getCliente());
	
		newobj.setCliente(cli);
		newobj.setTecnico(tec);
		
		if(newobj.getStatus().getCod().equals(2)) {
			newobj.setDataFechamento(LocalDateTime.now());
		}
		
		return repository.save(newobj);
	}
	
	public OS fromDTOS (OsDTO objDTO) {
		OS newobj = new OS();
		newobj.setId(objDTO.getId());
		newobj.setPrioridade(Prioridade.toEnum(objDTO.getPrioridade().getCod()));
		newobj.setStatus(Status.toEnum(objDTO.getStatus().getCod()));
		newobj.setObservcoes(objDTO.getObservcoes());
		
		Tecnico tec = tecnicoService.findById(objDTO.getTecnico());
		Cliente cli = clienteService.findById(objDTO.getCliente());
	
		newobj.setCliente(cli);
		newobj.setTecnico(tec);
		
		if(newobj.getStatus().getCod().equals(2)) {
			newobj.setDataFechamento(LocalDateTime.now());
		}
		
		return repository.save(newobj);
	}



	public void delete(Integer id) {
		repository.deleteById(id);	
		
	}
	
	
}
