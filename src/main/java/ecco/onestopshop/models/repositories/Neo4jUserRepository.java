/*
 * written by Daniel Ashcroft
 */

package ecco.onestopshop.models.repositories;

import ecco.onestopshop.models.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Collection;

public interface Neo4jUserRepository extends Neo4jRepository<User, Long> {

    @Query("MATCH (u:User) RETURN u")
    Collection<User> getAllUsers();
}
