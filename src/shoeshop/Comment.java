package shoeshop;

import java.util.Date;

public class Comment {
    private int id;
    private String titel;
    private String commentText;
    private Customer customer;
    private Date dateCreated;
    private Date lastUpdated;
    
    public Comment(int id, String titel, String commentText, Customer customer, Date dateCreated, Date lastUpdated){
        this.id = id;
        this.titel = titel;
        this.commentText = commentText;
        this.customer = customer;
        this.dateCreated = dateCreated;
        this.lastUpdated = lastUpdated;
    }

    public int getId() {
        return id;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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
