package ecco.onestopshop.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.expression.Lists;

import ecco.onestopshop.models.Question;
import ecco.onestopshop.models.Questions;
import ecco.onestopshop.components.QuestionsRepository;
import ecco.onestopshop.models.Answer;

@Controller
public class GetPageController {


	@Autowired
	private QuestionsRepository mongo;
	

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/test")
    public String test(){
        return "test";
    }

    @RequestMapping("/learn")
    public String learn(){
        return "learn";
    }

    @RequestMapping("/registration")
    public String registration(){
        return "registration";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    
    @RequestMapping("/decisionPlan")
    public String techDecisionPlan(Model model) {

    	ArrayList<Questions> questionsMongo = new ArrayList<Questions>(StreamSupport.stream(mongo.findAll().spliterator(),false).collect(Collectors.toList()));
    	
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
    	
    	
		model.addAttribute("questions", questions);		
    	return "decisionPlan";
    }

    @RequestMapping("/profil")
    public String profil(){ return "profil";}
}
