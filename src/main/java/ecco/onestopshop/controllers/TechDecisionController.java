package ecco.onestopshop.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.security.auth.x500.X500Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ecco.onestopshop.models.Answer;
import ecco.onestopshop.models.AnswerString;
import ecco.onestopshop.models.BeginnersAnswer;
import ecco.onestopshop.models.CounterEnergy;
import ecco.onestopshop.models.Question;
import ecco.onestopshop.models.QuestionsBeginner;
import ecco.onestopshop.models.repositories.QuestionsRepository;

@Controller
public class TechDecisionController 
{

	@Autowired
	private QuestionsRepository mongo;
	

	@RequestMapping("/selectLevel")
    public String techDecisionPlan(Model model, @RequestParam String level) {

		switch(level)
		{
			case "beginner":
				return getBeginnersDecisionPlan(model);
			case "advance":
				return getBeginnersDecisionPlan(model);
			default:
				return getBeginnersDecisionPlan(model);
		}
    	
    }
	
	
	
	
	
	private String getBeginnersDecisionPlan(Model model) {
		ArrayList<QuestionsBeginner> questionsMongo = new ArrayList<QuestionsBeginner>(StreamSupport.stream(mongo.findAll().spliterator(),false).collect(Collectors.toList()));
    	
    	ArrayList<Question> questions = new ArrayList<Question>();
		
		questionsMongo.forEach( questionFromMongo ->{
			Question tempQuestion = new Question();
			tempQuestion.setQuestionText(questionFromMongo.getQuestion());
			ArrayList<Answer> tempAnswers = new ArrayList<Answer>();
			Arrays.asList(questionFromMongo.getAnswers()).forEach( answer -> {
				String[] splittedAnswer = answer.split("@");
				tempAnswers.add(new Answer(splittedAnswer[0], splittedAnswer[1], Integer.valueOf(splittedAnswer[2])));
			});
			tempQuestion.setAnswerList(tempAnswers);
			questions.add(tempQuestion);
			
			
		});
		
    	
    	model.addAttribute("userSelection", new BeginnersAnswer(new AnswerString[questions.size()]));
		model.addAttribute("questions", questions);		
    	return "decisionPlan";
	}
	
	@RequestMapping("/processBeginners")
	public String processBeginnersPlan( @ModelAttribute BeginnersAnswer userSelection, Model model ) {
		CounterEnergy counters = new CounterEnergy();
		for(AnswerString x: Arrays.asList(userSelection.getUserSelection())) {
			counters.addPoints(x.getTheAnswer());
		};
		
		model.addAttribute("correctEnergyType", counters.getAccurateEnergy());
		return "decisionPlanEnergyType";
	}

}
