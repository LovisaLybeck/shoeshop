package shoeshop;

import java.sql.Timestamp;
import java.util.Date;

public class Color {
    private int id;
    private String name;
    private String description;
    private Date dateCreated;
    private Date lastUpdated;
    
    public Color(int id, String name, String description, Timestamp dateCreated, Timestamp lastUpdated){
        this.id = id;
        this.name = name;
        this.description = description;
        this.dateCreated = dateCreated;
        this.lastUpdated = lastUpdated;
    }
    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    
    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
