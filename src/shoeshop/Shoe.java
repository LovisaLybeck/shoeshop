package shoeshop;

import java.util.Date;

public class Shoe {
    private int id;
    private Size size;
    private Color color;
    private Model model; 
    private int inStock;
    private Date dateCreated;
    private Date lastUpdated;
    
    public Shoe(int id, Size size, Color color, Model model, int inStock, Date dateCreated, Date lastUpdated){
        this.id = id;
        this.size = size;
        this.color = color;
        this.model = model;
        this.inStock = inStock;
        this.dateCreated = dateCreated;
        this.lastUpdated = lastUpdated;
    }

    public int getId() {
        return id;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
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
