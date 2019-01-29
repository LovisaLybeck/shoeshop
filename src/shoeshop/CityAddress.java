package shoeshop;

import java.sql.Timestamp;
import java.util.Date;

public class CityAddress {
    private int id;
    private int zipcode;
    private String city;
    private Date dateCreated;
    private Date lastUpdated;
    
    public CityAddress(int id, int zipcode, String city, Timestamp dateCreated, Timestamp lastUpdated){
        this.id = id;
        this.zipcode = zipcode;
        this.city = city;
        this.dateCreated = dateCreated;
        this.lastUpdated = lastUpdated;
    }
    
    public int getId() {
        return id;
    }
    
    public int getZipcode() {
        return zipcode;
    }
    
    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String name) {
        this.city = name;
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
