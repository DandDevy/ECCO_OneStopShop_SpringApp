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

/*
 * written by Daniel Ashcroft
 */

package ecco.onestopshop.models;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * User location for recommendations
 */
@NodeEntity
public class Location {
    @GraphId
    private long id;
    private String name;

    public Location() {
    }

    public Location(String name) {
        this.name = name;
    }

    public Location(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
