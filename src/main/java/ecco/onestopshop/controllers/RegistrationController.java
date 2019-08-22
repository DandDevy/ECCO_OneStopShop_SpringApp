/*
 * written by Daniel Ashcroft
 */

package ecco.onestopshop.controllers;

import ecco.onestopshop.models.User;
import ecco.onestopshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for interaction through the server with post
 */
@RestController
@RequestMapping(value = "/registration")
public class RegistrationController {

    @Autowired
    UserService userService;


    /**
     * adds user to the system, if the user is unique
     * @param user
     */
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public void addUser(@RequestBody User user){
        if(userService.IsUserUnique(user))
            userService.addUser(user);
    }

//
//    private UserRepository userRepository;
//
//    @Autowired
//    public RegistrationController(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    /**
     * get all everything out of the user repository
     * @return
     */
//    @RequestMapping(value = "/all", method = RequestMethod.GET)
//    public List<User> getAll(){
//        return userRepository.findAll();
//    }
//
//
//    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
//    public void addUser(@RequestBody User user){
//
//        userRepository.save(user);
//        System.out.println("user to add " + user);
//    }
//
//    @RequestMapping(value = "/IsUserUnique", method = RequestMethod.POST)
//    public boolean IsUserUnique(@RequestBody User userTryingToGetIn){
//        boolean loginResponse = false;
//        System.out.println("userTryingToGetIn: " + userTryingToGetIn);
//        User user = userRepository.findByEmailAndUsernameAndPassword(userTryingToGetIn.getEmail(), userTryingToGetIn.getUsername(), userTryingToGetIn.getPassword());
//        System.out.println("findByEmailAndUsernameAndPassword user : " + user);
//        if(user != null){
//            loginResponse = true;
//        }
//
//        return loginResponse;
//    }
//
//    @RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
//    public boolean checkLogin(@RequestBody User userTryingToGetIn){
//        boolean loginResponse = false;
//        System.out.println("userTryingToGetIn: " + userTryingToGetIn);
//        User user = userRepository.findByEmailAndPassword(userTryingToGetIn.getEmail(), userTryingToGetIn.getPassword());
//        System.out.println("findByEmailAndPassword user : " + user);
//        if(user != null){
//            loginResponse = true;
//        }
//
//        System.out.println("login response: " + loginResponse);
//        return loginResponse;
//    }



}
