package ecco.onestopshop.models;

import org.springframework.data.mongodb.core.mapping.Document;


/**
 * 
 * @author Eduardo Lamas Suárez
 * Document representation needed for accessing to the advacne question collection
 *
 */
@Document
public class QuestionsAdvance 
{
	private String question;
	private String[] answer;
	private int position;
	
	public QuestionsAdvance(String question, String[] answer, int position) {
		this.question = question;
		this.answer = answer;
		this.position = position;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String[] getAnswer() {
		return answer;
	}

	public void setAnswer(String[] answer) {
		this.answer = answer;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

}
