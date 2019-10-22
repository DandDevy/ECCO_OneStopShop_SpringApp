/*
 * written by Daniel Ashcroft
 */

package ecco.onestopshop.models.repositories;

import ecco.onestopshop.models.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.ArrayList;
import java.util.Collection;

public interface Neo4jUserRepository extends Neo4jRepository<User, Long> {

    @Query("MATCH (u:User) RETURN u")
    Collection<User> getAllUsers();

    @Query("MERGE (u:User{email:{0}, username:{1}, password:{2} })")
    void addUser(String email, String username, String password);


    @Query("MATCH (u:User{username:{0}}) RETURN u Limit 1")
    User getByUsername(String username);


    @Query("MATCH (u:User{email:{0}, password:{1}}) RETURN u Limit 1")
    User getByLogin(String email, String password);

//    @Query("MATCH (u:User{username:{0}}) MERGE (u)-[:LIVES_IN]->(newL:Location{username:{1}}) ")
    @Query("MATCH (newL:Location{username:{1}}), (u:User{username:{0}}) MERGE (u)-[:LIVES_IN]->(newL) ")
    void setUserLocation(String username, String locationName);

    @Query("MATCH (u:User{username:{0}}), (u)-[r:LIVES_IN]->(:Location) DELETE r")
    void removeUserLocation(String username);

//    @Query("MATCH (u:User{username:{1}}) MERGE (u)-[:USES]->(r:RenewableTechnology{name:{0}})")
    @Query("MATCH (u:User{username:{1}}),(r:RenewableTechnology{name:{0}})  MERGE (u)-[:USES]->(r)")
    void setUserTechnology(String renewableTechName, String userLoggedInName);

    @Query("MATCH (w:User{username:{0}}), (w)-[r:USES]->(:RenewableTechnology) DELETE r")
    void clearTechnologies(String username);

//    @Query("")
//    ArrayList<User> matchUser(String username);
}
