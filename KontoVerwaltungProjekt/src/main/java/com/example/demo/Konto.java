package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Konto {
		
		@Id
		private Long idkonto;
	    private long matrikelnummer;
	    private double saldo;
	    private String passwort;
	    
	    public Konto(long idkonto, long matrikelnummer, double saldo,String passwort) {
	    	this.idkonto= idkonto;
	    	this.matrikelnummer=matrikelnummer;
	    	this.saldo=saldo;
	    	this.passwort=passwort;
	    }
	    
	    public Konto() {
	    	
	    }
	    
	    public String getPasswort() {
			return passwort;
		}

		public void setPasswort(String passwort) {
			this.passwort = passwort;
		}

		public Long getIdkonto() {
			return idkonto;
		}
		public void setIdkonto(Long idkonto) {
			this.idkonto = idkonto;
		}
		public long getMatrikelnummer() {
			return matrikelnummer;
		}
		public void setMatrikelnummer(long matrikelnummer) {
			this.matrikelnummer = matrikelnummer;
		}
		public double getSaldo() {
			return saldo;
		}
		public void setSaldo(double saldo) {
			this.saldo = saldo;
		}

		@Override
		public String toString() {
			return "Konto [idkonto=" + idkonto + ", matrikelnummer=" + matrikelnummer + ", saldo=" + saldo + ", passwort="
					+ passwort + "]";
		}
	    
	}

