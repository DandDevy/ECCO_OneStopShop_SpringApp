package ecco.onestopshop.models;

public class Answer 
{
	String answerText;
	String energyType;
	int points;
	
	public Answer(String answerText, String energyType, int points) {
		this.answerText = answerText;
		this.energyType = energyType;
		this.points = points;
	}

	public String getAnswerText() {
		return answerText;
	}

	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}

	public String getEnergyType() {
		return energyType;
	}

	public void setEnergyType(String energyType) {
		this.energyType = energyType;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
	
	public String getRadioButtonCode() {
		return energyType + "@" + points;
	}
	

}
