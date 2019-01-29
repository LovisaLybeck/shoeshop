package shoeshop;

import java.util.Date;

public class Grade {
    private int id;
    private Customer customer;
    private GradeLevel gradeLevel;
    private Date dateCreated;
    private Date lastUpdated;
    
    public Grade(int id, Customer customer, GradeLevel gradeLevel, Date dateCreated, Date lastUpdated){
        this.id = id;
        this.customer = customer;
        this.gradeLevel = gradeLevel;
        this.dateCreated = dateCreated;
        this.lastUpdated = lastUpdated;
    }
    
    public int getGradeNumber(){
        return gradeLevel.getLevelNumber();
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public GradeLevel getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(GradeLevel gradeLevel) {
        this.gradeLevel = gradeLevel;
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
