package com.bruno.OS.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.bruno.OS.services.DBService;


@Configuration
@Profile("teste")
public class TesteConfig {
	
	@Autowired
	private DBService dbservice;
	
	@Bean
	public void instaciaVB(){
		this.dbservice.instaciadb();
	}
}
