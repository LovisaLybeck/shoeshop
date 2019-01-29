package shoeshop;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class Model {
    private int id;
    private String name;
    private double price;
    private Brand brand;
    private List<Grade> grades;
    private List<Comment> comments;
    private Date dateCreated;
    private Date lastUpdated;
    
    public Model(int id, String name, double price, Brand brand, Timestamp dateCreated, Timestamp lastUpdated){
        this.id = id;
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.dateCreated = dateCreated;
        this.lastUpdated = lastUpdated;
    }
    
    public void addGrade(Grade grade){
        grades.add(grade);
    }
    
    public List getGrades(){
        return grades;
    }
    
    public void addComment(Comment comment){
        comments.add(comment);
    }
    
    public List getComments(){
        return comments;
    }
    
    public double getAvarageGrade(){
        double grade = 0;
        int numberOfGrades = 0;
        
        for(Grade g : grades){
            numberOfGrades++;
            grade += g.getGradeNumber();
        }
        
        return grade / numberOfGrades;
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
    
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
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
