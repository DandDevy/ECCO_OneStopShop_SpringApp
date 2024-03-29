/*
 * written by Daniel Ashcroft
 */

package ecco.onestopshop.models.TechDecisionAndProgressionEvaluationData;

/**
 * 
 * @author Eduardo Lamas Suárez
 * Class used to hold the answers and make the managing and handing easier
 */
public class Answer 
{
	String answerText;
	String extraInfo;
	int points;
	
	public Answer(String answerText, String extraInfo, int points) {
		this.answerText = answerText;
		this.extraInfo = extraInfo;
		this.points = points;
	}

	public String getAnswerText() {
		return answerText;
	}

	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}

	public String getExtraInfo() {
		return extraInfo;
	}

	public void setExtraInfo(String extraInfo) {
		this.extraInfo = extraInfo;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
	
	public String getRadioButtonBeginnerCode() {
		return extraInfo + "@" + points;
	}
	public String getRadioButtonAdvanceCode() {
		return extraInfo ;
	}
	

}
