package com.mouse.ws;

//import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "domande_test")
@IdClass(DomandeTestSerialize.class)

public class DomandeTest {
	
	@Id //Database primary key
	private long id_test;
	
	@Id //Database primary key
	private long id_domanda;

	public DomandeTest() {}

	public DomandeTest(long IdTest, long IdDomanda) {
		this.id_test = IdTest;
		this.id_domanda = IdDomanda;
	}

	public long getIdTest() {
		return id_test;
	}

	public void setIdTest(int idTest) {
		id_test = idTest;
	}

	public long getIdDomanda() {
		return id_domanda;
	}

	public void setIdDomanda(int idDomanda) {
		id_domanda = idDomanda;
	}
	
	@Override
	public String toString() {
		return "Utente [idTest=" + id_test + ", IdDomanda=" + id_domanda + "]";
	}

}
