package ecco.onestopshop.models;

import java.util.ArrayList;

/**
 * 
 * @author Eduardo Lamas Suárez
 * Class used to hold the answer selected in the begginers form 
 *
 */
public class BeginnersAnswer 
{
	private AnswerString[] userSelection;
	
	public BeginnersAnswer(AnswerString[] userSelection) {
		this.userSelection = userSelection;
		
	}

	
	
	public AnswerString[] getUserSelection() {
		return userSelection;
	}

	public void setUserSelection(AnswerString[] userSelection) {
		this.userSelection = userSelection;
	}

}
