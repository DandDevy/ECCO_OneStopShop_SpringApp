package ecco.onestopshop.controllers;

import ecco.onestopshop.models.User;
import ecco.onestopshop.models.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for interaction through the server with post
 */
@RestController
@RequestMapping(value = "/registration")
public class RegistrationController {
    private UserRepository userRepository;

    @Autowired
    public RegistrationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<User> getAll(){
        return userRepository.findAll();
    }


    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public void addUser(@RequestBody User user){

        userRepository.save(user);
        System.out.println("user to add " + user);

    }

    @RequestMapping(value = "/checkUser", method = RequestMethod.POST)
    public boolean checkUser(@RequestBody User userTryingToGetIn){
        boolean loginResponse = false;
        System.out.println("userTryingToGetIn: " + userTryingToGetIn);
        User user = userRepository.findByEmailAndAndUsernameAndPassword(userTryingToGetIn.getEmail(), userTryingToGetIn.getUsername(), userTryingToGetIn.getPassword());
        System.out.println("findByEmailAndAndUsernameAndPassword user : " + user);
        if(user != null){
            loginResponse = true;
        }

        return loginResponse;
    }

}
