/*
 * written by Daniel Ashcroft
 */

package ecco.onestopshop.services;

import ecco.onestopshop.models.User;
import ecco.onestopshop.models.repositories.Neo4jUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

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
     * gets a user off the system who has the same login data.
     * @param userTryingToLogin
     * @return
     */
    public User getUserbyLogin(User userTryingToLogin) {
        return neo4jUserRepository.getByLogin(userTryingToLogin.getEmail(), userTryingToLogin.getPassword());
    }
}
