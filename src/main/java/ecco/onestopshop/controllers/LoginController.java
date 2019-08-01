/*
 * written by Daniel Ashcroft
 */

package ecco.onestopshop.controllers;

import ecco.onestopshop.models.User;
import ecco.onestopshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
    private User userLoggedIn;

    private boolean userCanEnter;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    @ResponseBody
    public boolean login(@RequestBody User userTryingToLogin){

        boolean res = false;

        userLoggedIn = userService.getUserbyLogin(userTryingToLogin);
        if(userLoggedIn != null){
            userCanEnter = true;
            res = true;

        }

        System.out.println("\n--- User wishing to login: " + userTryingToLogin +"   -----\n");

        return res;
    }

    @RequestMapping("/profil")
    public String profil(){
        if(userCanEnter)
            return "profil";
        else
            return "login";
    }
}
