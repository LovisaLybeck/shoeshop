package shoeshop;

import java.sql.Timestamp;
import java.util.Date;

public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private String streetAddress;
    private CityAddress cityaddress;
    private Date dateCreated;
    private Date lastUpdated;
    
    public Customer(int id, String firstName, String lastName, String streetAddress, 
            CityAddress cityAddress, Timestamp dateCreated, Timestamp lastUpdated){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.cityaddress = cityaddress;
        this.dateCreated = dateCreated;
        this.lastUpdated = lastUpdated;
    }

    public int getId() {
        return id;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public CityAddress getCityaddress() {
        return cityaddress;
    }

    public void setCityaddress(CityAddress cityaddress) {
        this.cityaddress = cityaddress;
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
