package ecco.onestopshop.models;

import java.util.ArrayList;

public class Question 
{
	private String questionText;
	private ArrayList<Answer> answerList;
	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	public ArrayList<Answer> getAnswerList() {
		return answerList;
	}
	public void setAnswerList(ArrayList<Answer> answerList) {
		this.answerList = answerList;
	}
	public Question(String questionText, ArrayList<Answer> answerList) {
		this.questionText = questionText;
		this.answerList = answerList;
	}
	
	
}
