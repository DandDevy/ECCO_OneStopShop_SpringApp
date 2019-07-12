package ecco.onestopshop.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.security.auth.x500.X500Principal;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.omg.CORBA.Current;
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
import ecco.onestopshop.models.QuestionAdvance;
import ecco.onestopshop.models.QuestionBeginner;
import ecco.onestopshop.models.QuestionsAdvance;
import ecco.onestopshop.models.QuestionsBeginner;
import ecco.onestopshop.models.repositories.QuestionsAdvanceRepository;
import ecco.onestopshop.models.repositories.QuestionsBeginnerRepository;

@Controller
public class TechDecisionController 
{

	@Autowired
	private QuestionsBeginnerRepository mongoBeginner;
	
	@Autowired
	private QuestionsAdvanceRepository mongoAdvance;
	

	@RequestMapping("/selectLevel")
    public String techDecisionPlan(Model model, @RequestParam String level) {

		switch(level)
		{
			case "beginner":
				return getBeginnersDecisionPlan(model);
			case "advance":
				return getAdvanceDecisionPlan(model);
			default:
				return getBeginnersDecisionPlan(model);
		}
    	
    }
	
	
	
	
	
	private String getBeginnersDecisionPlan(Model model) {
		ArrayList<QuestionsBeginner> questionsMongo = new ArrayList<QuestionsBeginner>(StreamSupport.stream(mongoBeginner.findAll().spliterator(),false).collect(Collectors.toList()));
    	
    	ArrayList<QuestionBeginner> questions = new ArrayList<QuestionBeginner>();
		
		questionsMongo.forEach( questionFromMongo ->{
			QuestionBeginner tempQuestion = new QuestionBeginner();
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
	
	private String getAdvanceDecisionPlan(Model model) {
		
		ArrayList<QuestionsAdvance> questionOfMongo = new ArrayList<QuestionsAdvance>(StreamSupport.stream(mongoAdvance.findAll().spliterator(),false ).collect(Collectors.toList()));
		ArrayList<QuestionAdvance> questions = new ArrayList<QuestionAdvance>();
		questionOfMongo.forEach(questionMongo -> {
			ArrayList<Answer> tempAnswers = new ArrayList<Answer>(Arrays.asList(questionMongo.getAnswer()).stream()
			.map(answerMongo -> answerMongo.split("@"))
			.map(splitted ->(splitted.length==1)?new Answer(splitted[0],"",0):new Answer(splitted[0],splitted[1],0))
			.collect(Collectors.toList()));
			questions.add(new QuestionAdvance(questionMongo.getQuestion(), tempAnswers, questionMongo.getPosition()));
		});
		model.addAttribute("questions", questions);
		return "";
		
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
