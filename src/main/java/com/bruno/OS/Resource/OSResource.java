package com.bruno.OS.Resource;

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

import java.util.List;
import java.io.Serializable;
import java.net.URI;
import java.util.ArrayList;

import com.bruno.OS.domain.OS;
import com.bruno.OS.domain.dtos.OsDTO;
import com.bruno.OS.services.OSservice;

import jakarta.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/os")
public class OSResource implements Serializable {
	private static final long serialVersionUID = 1L;
	@Autowired
	private OSservice service;
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<OsDTO> findById(@PathVariable Integer id){
		OsDTO objDTO = new OsDTO(service.findById(id));
		return ResponseEntity.ok().body(objDTO);
	}
	
	@GetMapping
	public ResponseEntity<List<OsDTO>> findAll(){
		List<OS> list = service.findAll();
		List<OsDTO> listDTO = new ArrayList<>();
		list.forEach(obj -> listDTO.add(new OsDTO(obj)));
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<OsDTO> create( @RequestBody OsDTO objDTO){
		OS newobj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id").buildAndExpand(newobj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping
	public ResponseEntity<OsDTO> uptade(@Valid @RequestBody OsDTO objDTO){
		objDTO = new OsDTO(service.uptade(objDTO));
		return ResponseEntity.ok().body(objDTO); 
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
