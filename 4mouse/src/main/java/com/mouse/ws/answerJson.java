package com.mouse.ws;

public class answerJson {
	
	String idAnswer;
	String textAnswer;
	int points;
	
	public answerJson(String idAnswer, String textAnswer, int points) {
		super();
		this.idAnswer = idAnswer;
		this.textAnswer = textAnswer;
		this.points = points;
	}
	
	
	public String getIdAnswer() {
		return idAnswer;
	}
	public void setIdAnswer(String idAnswer) {
		this.idAnswer = idAnswer;
	}
	public String getTextAnswer() {
		return textAnswer;
	}
	public void setTextAnswer(String textAnswer) {
		this.textAnswer = textAnswer;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}

}
