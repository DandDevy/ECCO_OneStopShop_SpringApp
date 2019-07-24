package ecco.onestopshop.models;

import java.util.ArrayList;

/**
 * 
 * @author Eduardo Lamas Suárez
 * Class made with the aim of holding an advance question of the database
 *
 */
public class QuestionAdvance extends QuestionBeginner
{
	int position;
	


public QuestionAdvance(String questionText, ArrayList<Answer> answerList, int position) {
	super(questionText, answerList);
	this.position = position;
}


public int getPosition() {
		return position;
	}


public void setPosition(int position) {
	this.position = position;
}


}
