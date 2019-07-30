/*
 * written by Daniel Ashcroft
 */

package ecco.onestopshop.models.repositories;

import ecco.onestopshop.models.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Collection;
import java.util.Optional;

public interface Neo4jUserRepository extends Neo4jRepository<User, Long> {

    @Query("MATCH (u:User) RETURN u")
    Collection<User> getAllUsers();

    @Query("MERGE (u:User{email:{0}, username:{1}, password:{2} })")
    void addUser(String email, String username, String password);


    @Query("MATCH (u:User{username:{0}}) RETURN u")
    Collection<User> getByUsername(String username);
}
