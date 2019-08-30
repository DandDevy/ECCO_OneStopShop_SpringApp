/*
 * written by Daniel Ashcroft
 */

package ecco.onestopshop.services;

import ecco.onestopshop.models.Location;
import ecco.onestopshop.models.RenewableTechnology;
import ecco.onestopshop.models.User;
import ecco.onestopshop.models.repositories.Neo4jUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

/**
 * services to the user repository
 */
@Service
public class UserService {
    @Autowired
    Neo4jUserRepository neo4jUserRepository;

    /**
     * gets all the users on the system
     * @return Collection<User>
     */
    public Collection<User> getAllUsers(){

        return neo4jUserRepository.getAllUsers();
    }


    /**
     * Adds user to the system.
     * @param user
     */
    public void addUser(User user) {
        neo4jUserRepository.addUser(user.getEmail(), user.getUsername(), user.getPassword());
    }

    /**
     * checks if any user on the system has the same credentials.
     * @param user
     * @return boolean
     */
    public boolean IsUserUnique(User user) {
        boolean res = true;

        User userFound = neo4jUserRepository.getByUsername(user.getUsername());
        if(userFound != null)
            res = false;

        return res;
    }


    /**
     * gets a user from the system who has the same login data.
     * @param userTryingToLogin
     * @return
     */
    public User getUserbyLogin(User userTryingToLogin) {
        return neo4jUserRepository.getByLogin(userTryingToLogin.getEmail(), userTryingToLogin.getPassword());
    }

    /**
     * sets the users location.
     * @param userLoggedIn
     * @param location
     */
    public void setUserLocation(User userLoggedIn, Location location) {

        neo4jUserRepository.removeUserLocation(userLoggedIn.getUsername());

        // if the user has selected something besides none
        if(!location.getName().equals("none")) {
            neo4jUserRepository.setUserLocation(userLoggedIn.getUsername(), location.getName());
        }

    }

    public void setUserTechnologies(ArrayList<RenewableTechnology> technologies, User userLoggedIn) {

        neo4jUserRepository.clearTechnologies(userLoggedIn.getUsername());

        if (technologies.size() > 0) {
            for (int i = 0; i < technologies.size(); i++){
                neo4jUserRepository.setUserTechnology(technologies.get(i).getName(), userLoggedIn.getUsername());

            }
        }
    }

    public void setUserTechnology(RenewableTechnology technology, User userLoggedIn) {
        neo4jUserRepository.clearTechnologies(userLoggedIn.getUsername());

        if(technology != null)
            System.out.println("User uses:" + technology.getName() + " is called" + userLoggedIn.getUsername());
            neo4jUserRepository.setUserTechnology(technology.getName(), userLoggedIn.getUsername());
    }

    public void setUserTechnologyToNone(User userLoggedIn) {
        neo4jUserRepository.clearTechnologies(userLoggedIn.getUsername());
    }

//    public ArrayList<User> matchUser(User userLoggedIn) {

//        return neo4jUserRepository.matchUser(userLoggedIn.getUsername());
//    }
}
