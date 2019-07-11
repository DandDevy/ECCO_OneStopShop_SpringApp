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
import ecco.onestopshop.models.QuestionsBeginner;
import ecco.onestopshop.models.repositories.QuestionsRepository;
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
    
    @RequestMapping("/decisionPlanIntro")
    public String getDecisionPlanIntroPage() {
    	return "decisionPlanIntro";
    }

    @RequestMapping("/profil")
    public String profil(){ return "profil";}
}
