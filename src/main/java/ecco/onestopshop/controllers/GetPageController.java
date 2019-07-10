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

    @RequestMapping("/registration")
    public String registration(){
        return "registration";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/profil")
    public String profil(){ return "profil";}
}
