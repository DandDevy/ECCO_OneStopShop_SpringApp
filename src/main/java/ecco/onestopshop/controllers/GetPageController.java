package ecco.onestopshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/resources")
    public String resources(){
        return "resources";
    }

    @RequestMapping("/registration")
    public String registration(){
        return "registration";
    }

    @RequestMapping(value = "/login")
    public String login(){

        return "login";
    }

    @RequestMapping(value = "/progressionAndUserTools")
    public String progressionAndTool(){

        return "progressionAndUserTools";
    }

    @RequestMapping("/decisionPlanIntro")
    public String getDecisionPlanIntroPage() {
    	return "decisionPlanIntro";
    }


    @RequestMapping("/financial")
    public String financial(){return "financial";}
}
