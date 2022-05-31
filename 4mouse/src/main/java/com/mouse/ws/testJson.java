package com.mouse.ws;

import java.util.ArrayList;
import java.util.List;

public class testJson {
	
	String idQuestion;
	String TestQuestion;
	int modalita;
	List<answerJson> answers = new ArrayList<answerJson>();
	
	public testJson() {};
	
	public testJson(String idQuestion, String testQuestion, int modalita, List<answerJson> answers) {
		super();
		this.idQuestion = idQuestion;
		TestQuestion = testQuestion;
		this.modalita = modalita;
		this.answers = answers;
	}

	public String getIdQuestion() {
		return idQuestion;
	}

	public void setIdQuestion(String idQuestion) {
		this.idQuestion = idQuestion;
	}

	public String getTestQuestion() {
		return TestQuestion;
	}

	public void setTestQuestion(String testQuestion) {
		TestQuestion = testQuestion;
	}

	public int getModalita() {
		return modalita;
	}

	public void setModalita(int modalita) {
		this.modalita = modalita;
	}

	public List<answerJson> getAnswers() {
		return answers;
	}

	public void setAnswers(List<answerJson> answers) {
		this.answers = answers;
	}
	
	@Override
	public String toString() {
	return "Esecuzione [idQuestion=" + idQuestion + ", TestQuestion=" + TestQuestion + ", modalita=" + modalita +  "]";
	}

}
