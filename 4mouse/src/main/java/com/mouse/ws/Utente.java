package com.mouse.ws;

import javax.persistence.*;

@Entity
@Table(name = "utente")

public class Utente {

	@Id ////Database primary key
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "tipo")
	private int tipo;

	public Utente() {

	}

	public Utente(String email, String password, int tipo) {
		this.email = email;
		this.password = password;
		this.tipo = tipo;
	}

	// GETTER & SETTER
	
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getTipo() {
		return this.tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Utente [email=" + email + ", password=" + password + ", tipo=" + tipo + "]";
	}
}