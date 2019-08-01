/*
 * written by Daniel Ashcroft
 */

package ecco.onestopshop.controllers;

import ecco.onestopshop.models.User;
import ecco.onestopshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "/userLogin")
public class LoginController {
    private User userLoggedIn;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/profil", method = RequestMethod.POST)
    public boolean login(@RequestBody User userTryingToLogin){

        boolean res = true;

        if(userService.isLoginCorrect(userTryingToLogin)){
            userLoggedIn = userService.getAllUserDetails(userTryingToLogin);
            res = true;
        }

        System.out.println("\n--- User wishing to login: " + userTryingToLogin +"   -----\n");

        return res;
    }
}
