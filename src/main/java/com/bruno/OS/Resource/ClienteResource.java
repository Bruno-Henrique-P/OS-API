package com.bruno.OS.Resource;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bruno.OS.domain.Cliente;
import com.bruno.OS.domain.Tecnico;
import com.bruno.OS.services.ClienteService;

import jakarta.validation.Valid;

import com.bruno.OS.domain.dtos.ClienteDTO;
import com.bruno.OS.domain.dtos.TecnicoDTO;


@CrossOrigin("*")
@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {
	// localhost:8080/tecnicos/id
	
	@Autowired
	private ClienteService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ClienteDTO> findById(@PathVariable Integer id){
		ClienteDTO objDTO = new ClienteDTO(service.findById(id));
		return ResponseEntity.ok().body(objDTO);
	}
	
	@GetMapping
	public ResponseEntity<List<ClienteDTO>> findAll(){
		List<Cliente> list = service.findAll();
		List<ClienteDTO> listDTO = new ArrayList<>();
		list.forEach(obj -> listDTO.add(new ClienteDTO(obj)));
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<ClienteDTO> create(@Valid @RequestBody ClienteDTO objDTO){
		Cliente newobj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id").buildAndExpand(newobj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ClienteDTO> uptade(@PathVariable Integer id , @Valid @RequestBody ClienteDTO objDTO){
		ClienteDTO newobj = new ClienteDTO(service.uptade(id,objDTO));
		return ResponseEntity.ok().body(newobj); 
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
