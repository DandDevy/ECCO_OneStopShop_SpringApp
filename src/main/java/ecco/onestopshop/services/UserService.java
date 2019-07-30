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

    public Collection<User> getAllUsers(){

        return neo4jUserRepository.getAllUsers();
    }


    public void addUser(User user) {
        neo4jUserRepository.addUser(user.getEmail(), user.getUsername(), user.getPassword());
    }

    public boolean IsUserUnique(User user) {
        boolean res = true;

        Collection<User> users = neo4jUserRepository.getByUsername(user.getUsername());
        System.out.println("users with these credentials are : " + users);

        if(users.size() > 0)
            res = false;

        return res;
    }
}
