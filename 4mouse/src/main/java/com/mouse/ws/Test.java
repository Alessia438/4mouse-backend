package com.mouse.ws;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "test")

public class Test {
	
	@Id ////Database primary key
	private long id_test;

	@Column(name = "data")
	private LocalDate data;
	
	public Test() {}

	public Test(long id_test, LocalDate data) {
		super();
		this.id_test = id_test;
		this.data = data;
	}

	public long getIdTest() {
		return id_test;
	}

	public void setIdTest(long idTest) {
		id_test = idTest;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "Utente [id test=" + id_test + ", data=" + data + "]";
	}

}
