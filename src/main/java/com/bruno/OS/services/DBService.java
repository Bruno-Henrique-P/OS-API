package com.bruno.OS.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruno.OS.domain.Cliente;
import com.bruno.OS.domain.OS;
import com.bruno.OS.domain.Tecnico;
import com.bruno.OS.domain.enuns.Prioridade;
import com.bruno.OS.domain.enuns.Status;
import com.bruno.OS.repository.ClienteRepository;
import com.bruno.OS.repository.OsRepository;
import com.bruno.OS.repository.TecnicoRepository;

@Service
public class DBService {
	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private OsRepository osRepository;
	
	
	
	
	public void instaciadb() {
		Tecnico t1 = new Tecnico(null , "TESTE com a oredm" , "700.963.070-48" , "(88) 98888-8888" );
		Cliente c1 = new Cliente (null , "TESTE com a ordem " ,"406.531.970-63" , "(88) 97777-7777");
		OS os1 = new OS(null , Prioridade.ALTA ,"apesnas um teste", Status.ANDAMENTO, t1, c1 );
	
			
		t1.getList().add(os1);
		c1.getList().add(os1);
		
		tecnicoRepository.saveAll(Arrays.asList(t1));
		clienteRepository.saveAll(Arrays.asList(c1));
		osRepository.saveAll(Arrays.asList(os1));
	}
}
