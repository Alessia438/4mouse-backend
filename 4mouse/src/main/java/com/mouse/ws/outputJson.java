package com.mouse.ws;

import java.util.ArrayList;
//import java.util.List;

import org.springframework.http.HttpStatus;


public class outputJson {
	
	HttpStatus status;
	long id_test;
	ArrayList<testJson> test = new ArrayList<testJson>();
	
	public outputJson(HttpStatus status, long id_test, ArrayList<testJson> test) {
		super();
		this.status = status;
		this.id_test = id_test;
		this.test = test;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public long getId_test() {
		return id_test;
	}

	public void setId_test(long id_test) {
		this.id_test = id_test;
	}

	public ArrayList<testJson> getTest() {
		return test;
	}

	public void setTest(ArrayList<testJson> test) {
		this.test = test;
	}
	
	@Override
	public String toString() {
	return "Esecuzione [stato=" + status + ", id_test=" + id_test + ", test=" + test.toString() +  "]";
	}

}
