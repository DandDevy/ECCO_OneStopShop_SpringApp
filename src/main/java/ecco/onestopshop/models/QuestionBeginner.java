package ecco.onestopshop.models;

import java.util.ArrayList;

/**
 * 
 * @author Eduardo Lamas Suárez
 * Class made with the purpose of holding and managing the beginner questions
 *
 */
public class QuestionBeginner 
{
	private String questionText;
	private ArrayList<Answer> answerList;
	
	public QuestionBeginner() {
		
	}
	public QuestionBeginner(String questionText, ArrayList<Answer> answerList) {
		this.questionText = questionText;
		this.answerList = answerList;
	}
	
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
	
	
	
}
