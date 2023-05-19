package com.bruno.OS.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bruno.OS.domain.Pessoa;
import com.bruno.OS.domain.Tecnico;
import com.bruno.OS.domain.dtos.TecnicoDTO;
import com.bruno.OS.repository.PessoaRepository;
import com.bruno.OS.repository.TecnicoRepository;
import com.bruno.OS.services.TecnicoService;
import com.bruno.OS.services.Exception.DataIntegratyViolationException;
import com.bruno.OS.services.Exception.ObjectNotFoundException;

import jakarta.validation.Valid;

@Service
public class TecnicoService {
	
	
	@Autowired
	private TecnicoRepository repository;
	
	@Autowired
	private PessoaRepository pessoarepository;
	
	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id:"
				+ id + " ,Tipo: " + Tecnico.class.getName()));
	}

	public List<Tecnico> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	
	public Tecnico create(TecnicoDTO objDTO) {
		if(findByCPF(objDTO) != null) {
			throw new DataIntegratyViolationException("CPF já cadastrado na base de dados!");
	}
		return repository.save( new Tecnico(null, objDTO.getNome(), objDTO.getCpf(),objDTO.getTelefone()));
	}
	
	public Tecnico uptade(Integer id, @Valid TecnicoDTO objDTO) {
		Tecnico oldobj = findById(id);
		
		if (findByCPF(objDTO) != null && findByCPF(objDTO).getId() != id) {
			throw new DataIntegratyViolationException("CPF já cadastrado na base de dados!");
		}
		
		oldobj.setNome(objDTO.getNome());
		oldobj.setCpf(objDTO.getCpf());
		oldobj.setTelefone(objDTO.getTelefone());
		
		return repository.save(oldobj);
		
	}
	
	private Pessoa findByCPF(TecnicoDTO objDTO) {
		Pessoa obj = pessoarepository.findByCPF(objDTO.getCpf());
		if(obj != null) {
			return obj;
		}
		return null;
}
	
	public void delete(Integer id) {
		Tecnico obj = findById(id);
		if (obj.getList().size() > 0 ) {
			throw new DataIntegratyViolationException("Tecnico possui ordens de serviços, não pode ser deletado");
		}
		repository.deleteById(id);	
	}	
	
	
}
