package ecco.onestopshop.models;

import java.util.ArrayList;

public class BeginnersAnswer 
{
	AnswerString[] userSelection;
	
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
