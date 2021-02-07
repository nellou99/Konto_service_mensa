package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableSwagger2
@SpringBootApplication
public class KontoVerwaltungProjektApplication implements CommandLineRunner {
	
	@Autowired
	KontoRepository kontoRepository;

	public static void main(String[] args) {
		SpringApplication.run(KontoVerwaltungProjektApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		kontoRepository.save(new Konto(0L, 2L, 200, "hardi"));
		
	}

}
