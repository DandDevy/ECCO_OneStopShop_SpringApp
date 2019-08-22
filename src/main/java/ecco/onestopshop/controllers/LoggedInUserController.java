/*
 * written by Daniel Ashcroft
 */

package ecco.onestopshop.controllers;

import ecco.onestopshop.models.Location;
import ecco.onestopshop.models.RenewableTechnology;
import ecco.onestopshop.models.User;
import ecco.onestopshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.ArrayList;

@Controller
public class LoggedInUserController {
    private User userLoggedIn;

    private boolean userCanEnter;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    @ResponseBody
    public boolean login(@RequestBody User userTryingToLogin){

        boolean res = false;

        userLoggedIn = userService.getUserbyLogin(userTryingToLogin);
        System.out.println("\n--- User wishing to login: " + userTryingToLogin +"   -----\n");

        if(userLoggedIn != null){
            userCanEnter = true;
            res = true;
            System.out.println("this user can login ->" + userLoggedIn);
        }

        return res;
    }

    @RequestMapping("/profil")
    public String profil(Model model){
        if(userCanEnter)
            return "profil";
        else
            return "login";
    }

    @RequestMapping(value = "/setUserLocation", method = RequestMethod.POST)
    @ResponseBody
    public void updateUserLocation(@RequestBody Location location){

        userService.setUserLocation(userLoggedIn, location);

        System.out.println("location user has selected: " + location);
    }

    @RequestMapping(value = "/setUserTechnologies", method = RequestMethod.POST)
    @ResponseBody
    public void updateUserTechnology(@RequestBody ArrayList<RenewableTechnology> technologies){

        userService.setUserTechnologies(technologies, userLoggedIn);
        System.out.println("technologies the user is using: " + technologies);
    }
    @RequestMapping(value = "/setUserTechnology", method = RequestMethod.POST)
    @ResponseBody
    public void updateUserTechnology(@RequestBody RenewableTechnology technology){

        userService.setUserTechnology(technology, userLoggedIn);
        System.out.println("technologies the user is using: " + technology);
    }

    @RequestMapping(value = "/profilData", method = RequestMethod.POST)
    @ResponseBody
    public void updateUserData(@RequestBody ArrayList profilData){

        profilData.forEach(i  -> System.out.println(i));
//        for(int i = 0; i < profilData.length; i++)
//            System.out.println(userLoggedIn + " is from "+profilData[i]);
    }
}
