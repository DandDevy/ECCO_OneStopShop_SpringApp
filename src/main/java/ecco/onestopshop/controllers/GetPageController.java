package ecco.onestopshop.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ecco.onestopshop.models.Question;
import ecco.onestopshop.models.Answer;

@Controller
public class GetPageController {

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

		ArrayList<Question> questions = new ArrayList<Question>();
		ArrayList<Answer> answers = new ArrayList<Answer>();
		answers.addAll( Arrays.asList(new Answer[] {new Answer("EDU", "W", 10), new Answer("Ramon", "PV", 20)}));
		questions.add(new Question("Which is your name?", answers));
		
		model.addAttribute("questions", questions);		
    	return "decisionPlan";
    }

    @RequestMapping("/profil")
    public String profil(){ return "profil";}
}
