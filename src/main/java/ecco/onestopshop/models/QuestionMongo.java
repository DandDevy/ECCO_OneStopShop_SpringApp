package ecco.onestopshop.models;

public class QuestionMongo {

		String question;
		String[] answers;
		
		public QuestionMongo(String question, String[] answers)
		{
			this.question = question;
			this.answers = answers;
		}

		public String getQuestion() {
			return question;
		}

		public void setQuestion(String question) {
			this.question = question;
		}

		public String[] getAnswers() {
			return answers;
		}

		public void setAnswers(String[] answers) {
			this.answers = answers;
		}
}
