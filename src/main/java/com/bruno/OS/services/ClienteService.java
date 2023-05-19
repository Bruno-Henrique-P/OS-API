package com.bruno.OS.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruno.OS.domain.Cliente;
import com.bruno.OS.domain.Tecnico;
import com.bruno.OS.domain.dtos.ClienteDTO;
import com.bruno.OS.domain.dtos.TecnicoDTO;
import com.bruno.OS.repository.ClienteRepository;
import com.bruno.OS.services.Exception.DataIntegratyViolationException;
import com.bruno.OS.services.Exception.ObjectNotFoundException;

import jakarta.validation.Valid;


@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
		
	public Cliente findById(Integer id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: "
				+ id + " ,Tipo: " + Cliente.class.getName()));
	}
	
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	
	public Cliente create(ClienteDTO objDTO) {
		if(findByCPF(objDTO) != null) {
			throw new DataIntegratyViolationException("CPF já cadastrado na base de dados!");
	}
		return repository.save( new Cliente(null, objDTO.getNome(), objDTO.getCpf(),objDTO.getTelefone()));
	}
	
	public Cliente uptade(Integer id, @Valid ClienteDTO objDTO) {
		Cliente oldobj = findById(id);
		
		if (findByCPF(objDTO) != null && findByCPF(objDTO).getId() != id) {
			throw new DataIntegratyViolationException("CPF já cadastrado na base de dados!");
		}
		
		oldobj.setNome(objDTO.getNome());
		oldobj.setCpf(objDTO.getCpf());
		oldobj.setTelefone(objDTO.getTelefone());
		
		return repository.save(oldobj);
		
	}
	
	private Cliente findByCPF(ClienteDTO objDTO) {
		Cliente obj = repository.findByCPF(objDTO.getCpf());
		if(obj != null) {
			return obj;
		}
		return null;
}

	public void delete(Integer id) {
		Cliente obj = findById(id);
		if (obj.getList().size() > 0 ) {
			throw new DataIntegratyViolationException("Cliente possui ordens de serviços, não pode ser deletado");
		}
		repository.deleteById(id);
	
	}
}


