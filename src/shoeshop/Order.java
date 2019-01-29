package shoeshop;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class Order {
    private int id;
    private Customer customer;
    private boolean shipped;
    private List<Shoe> shoes;
    private Date dateCreated;
    private Date lastUpdated;
    
    public Order(int id, Customer customer, boolean shipped, Timestamp dateCreated, Timestamp lastUpdated){
        this.id = id;
        this.customer = customer;
        this.shipped = shipped;
        this.dateCreated = dateCreated;
        this.lastUpdated = lastUpdated;
    }
    
    public void addShoe(Shoe shoe){
        shoes.add(shoe);
    }
    
    public List getShoes(){
        return shoes;
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

    public boolean isShipped() {
        return shipped;
    }

    public void setShipped(boolean shipped) {
        this.shipped = shipped;
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
