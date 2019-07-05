package ecco.onestopshop.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/post")
public class PostController {
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public void addUser(){

    }

}
