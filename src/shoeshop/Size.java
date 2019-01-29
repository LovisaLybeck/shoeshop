package shoeshop;

import java.sql.Timestamp;
import java.util.Date;

public class Size {
    private int id;
    private String name;
    private Date dateCreated;
    private Date lastUpdated;
    
    public Size(int id, String name, Timestamp dateCreated, Timestamp lastUpdated){
        this.id = id;
        this.name = name;
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
