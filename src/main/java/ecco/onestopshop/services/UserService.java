/*
 * written by Daniel Ashcroft
 */

package ecco.onestopshop.services;

import ecco.onestopshop.models.User;
import ecco.onestopshop.models.repositories.Neo4jUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

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


}
