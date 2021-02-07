package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api")
public class KontoRestService {
	@Autowired
	KontoRepository kontorepository;
	
	@GetMapping(path = "/konto" , produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Konto> getKonto() {
		return kontorepository.findAll();
	}
	
	@GetMapping(path = "/konto/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Konto getOneKonto1(@PathVariable(value = "id") Long id) {
		return kontorepository.findById(id).get();
	}
	
	@GetMapping(path = "/konto/getMatrikelnummer/{Matrikelnummer}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Konto getOneKonto(@PathVariable(value = "matrikelnummer") Long matrikelnummer) {
		return kontorepository.findByMatrikelnummer(matrikelnummer);
	}
	
	@PostMapping(path = "/Konto", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Konto save(@RequestBody Konto konto) {
		//String fileName = fileStorageService.storeFile(file);
		//Konto.setBild(fileName);
		return kontorepository.save(konto); 
	}
	
	@PutMapping(path = "/Konto/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Konto save(@RequestBody Konto Konto, @PathVariable(value = "id") Long id) {
		Konto.setIdkonto(id);
		return kontorepository.save(Konto);
	}
	
	@DeleteMapping(path = "/Konto/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public boolean delete(@PathVariable Long id) {
		
		try {
			kontorepository.deleteById(id);
		return true;
			
		}catch (Exception e) {
			return false;
		}
	}
	@GetMapping(path= "/Konto/einzahlen/{summe}/{matrikelnummer}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public void einzahlen(@PathVariable(value="summe") double betrag,@PathVariable(value = "matrikelnummer") Long nummer) {
		Konto konto =kontorepository.findByMatrikelnummer(nummer);
		if (konto != null) {
			double saldo = konto.getSaldo();
			saldo += betrag;
			konto.setSaldo(saldo);
			kontorepository.save(konto);
		}
		
		
	}
	@GetMapping(path = "/Konto/auszahlen/{summe}/{matrikelnummer}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public boolean auszahlen(@PathVariable(value ="summe") double betrag,@PathVariable(value = "matrikelnummer") Long nummer) {
		Konto konto= kontorepository.findByMatrikelnummer(nummer);
		double saldo= konto.getSaldo();
		if(saldo>=betrag) {
			saldo-= betrag;
			konto.setSaldo(saldo);
			kontorepository.save(konto);
			
			return true;
		}
		return false;
		}
	}

