package ecco.onestopshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ecco.onestopshop.components.QuestionsRepository;

@Controller
public class TechDecisionController 
{
	
	@Autowired
	private QuestionsRepository mongo;

}
