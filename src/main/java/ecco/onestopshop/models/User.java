/*
 * written by Daniel Ashcroft
 */

/*
 * written by Daniel Ashcroft
 */

/*
 * written by Daniel Ashcroft
 */

/*
 * written by Daniel Ashcroft
 */

package ecco.onestopshop.models;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

//@Entity
@NodeEntity
public class User implements Comparable{
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @GraphId
    private long id;

    private String username, email, password;

    public User() {
    }



    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        int res = -1;

        if(o instanceof User){
            User otherUser = (User) o;
            boolean isSame = otherUser.getUsername().equals(this.getUsername());
            if(isSame)
                res = 0;
        }
        return res;
    }
}
