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
 * A renewable technology class that can be used as a graph node as well and for recommendations.
 */
@NodeEntity
public class RenewableTechnology {
    @GraphId
    private long id;

    private String name;

    public RenewableTechnology() {
    }

    public RenewableTechnology(String name) {
        this.name = name;
    }

    public RenewableTechnology(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RenewableTechnology{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
