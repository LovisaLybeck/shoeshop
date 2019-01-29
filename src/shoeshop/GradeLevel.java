package shoeshop;

import java.sql.Timestamp;
import java.util.Date;

public class GradeLevel {
    private int id;
    private String level;
    private int levelNumber;
    private Date dateCreated;
    private Date lastUpdated;
    
    public GradeLevel(int id, String level, int levelNumber, Timestamp dateCreated, Timestamp lastUpdated){
        this.id = id;
        this.level = level;
        this.levelNumber = levelNumber;
        this.dateCreated = dateCreated;
        this.lastUpdated = lastUpdated;
    }
    
    public int getId() {
        return id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String name) {
        this.level = name;
    }
    
    public int getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
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
