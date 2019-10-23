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

    public ArrayList<User> matchUser(User userLoggedIn) {
        ArrayList<User> matchedUsers = new ArrayList<User>();

        Collection<User> usersMatchedByLocationAsCollection = neo4jUserRepository.matchUserByLocation(userLoggedIn.getUsername());
        ArrayList<User> usersMatchedByLocationWithoutLoggedIn = new ArrayList<>();
        for(User matchedUser : usersMatchedByLocationAsCollection){
            if(matchedUser.compareTo(userLoggedIn) != 0)
                usersMatchedByLocationWithoutLoggedIn.add(matchedUser);
        }

        Collection<User> usersMatchedByTechAsCollection = neo4jUserRepository.matchUserByTech(userLoggedIn.getUsername());
        ArrayList<User> usersMatchedByTechWithoutLoggedIn = new ArrayList<>();
        for(User matchedUser : usersMatchedByTechAsCollection){
            if(matchedUser.compareTo(userLoggedIn) != 0)
                usersMatchedByTechWithoutLoggedIn.add(matchedUser);
        }
        System.out.println("usersMatchedByLocation with " + userLoggedIn + " are :" + usersMatchedByLocationWithoutLoggedIn);
        System.out.println("usersMatchedByTech with " + userLoggedIn + " are :" + usersMatchedByTechWithoutLoggedIn);


        //keep cleaning


        for(User userMatchedByLocation : usersMatchedByLocationWithoutLoggedIn){
            for(User userMatchedByTech : usersMatchedByTechWithoutLoggedIn){
                if(userMatchedByLocation.compareTo(userMatchedByTech) == 0) {
                    matchedUsers.add(userMatchedByLocation);
//                    usersMatchedByLocationWithoutLoggedIn.remove(userMatchedByLocation);
//                    usersMatchedByTechWithoutLoggedIn.remove(userMatchedByTech);
                }
            }
        }
//        for(User userMatchedByLocation : usersMatchedByLocationWithoutLoggedIn){
////            if(matchedUsers.size() == 0){
////
////            }
//            for(int i = 0; i < matchedUsers.size(); i ++){
//                System.out.println("matchedUsers ");
//                if(userMatchedByLocation.compareTo(matchedUsers.get(i)) != 0){
//                    matchedUsers.add(userMatchedByLocation);
//                }
//            }
//        }
////        matchedUsers.addAll(usersMatchedByLocationWithoutLoggedIn);
//
//        for(User userMatchedByTech : usersMatchedByTechWithoutLoggedIn){
//            for(int i = 0; i < matchedUsers.size(); i ++){
//                if(userMatchedByTech.compareTo(matchedUsers.get(i)) != 0){
//                    matchedUsers.add(userMatchedByTech);
//                }
//            }
//        }

//        matchedUsers.addAll(usersMatchedByTechWithoutLoggedIn);

        System.out.println("matchedUsers: " + matchedUsers);
        return matchedUsers;
    }

    public void setMatch(User userLoggedIn, ArrayList<User> othersThatCouldBeMatchedWith) {
        for(User user : othersThatCouldBeMatchedWith){
            neo4jUserRepository.setMatch(userLoggedIn.getUsername(), user.getUsername());
        }
    }

//    public ArrayList<User> matchUser(User userLoggedIn) {

//        return neo4jUserRepository.matchUser(userLoggedIn.getUsername());
//    }
}
