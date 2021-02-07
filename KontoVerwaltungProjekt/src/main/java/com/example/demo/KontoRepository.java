package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface KontoRepository extends JpaRepository<Konto, Long> {
	
	Konto findByMatrikelnummer(Long matrikelnummer);


}
