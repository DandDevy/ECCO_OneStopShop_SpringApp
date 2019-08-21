/*
 * written by Daniel Ashcroft
 */

package ecco.onestopshop.Resources;

import ecco.onestopshop.models.UserData.User;
import ecco.onestopshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/rest/neo4j/user")
public class AllUsersResource {

    @Autowired
    UserService userService;

    @GetMapping
    public Collection<User> getAllUsers(){
        return userService.getAllUsers();
    }
}
