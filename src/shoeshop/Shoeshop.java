
package shoeshop;

import java.awt.FlowLayout;
import java.util.*;
import javax.swing.*;


public class Shoeshop extends JFrame{
    
    JPanel panel = new JPanel();
    JLabel label = new JLabel("Välj användare: ");
    
    Map<JButton, Integer> buttonList = new HashMap();
    Map<Integer, Customer> customerMap = new HashMap();
    Map<Integer, Shoe> shoesMap = new HashMap();
    Map<Integer, Order> ordersMap = new HashMap();
    
    int customerID;
    int shoeID;
    int orderID;
    
    Repository r;
    
    public Shoeshop(){
        panel.setLayout(new FlowLayout());
        add(panel);
        panel.add(label);
        
        r = new Repository();
        
        customerMap = r.getAllCustomers(customerMap);
        customerMap.forEach((k, v) -> buttonList.put(new JButton(v.getFirstName() 
                + " " + v.getLastName()), k));
        
        buttonList.forEach((k, v) -> panel.add(k));
        buttonList.forEach((k, v) -> k.addActionListener(e -> {
            customerID = buttonList.get(e.getSource());
            changeButtonsToShoes();
        }));
        
        setSize(200, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void changeButtonsToShoes(){
        buttonList.clear();
        panel.removeAll();
        panel.add(label);
        label.setText("Välj sko: ");
        
        shoesMap = r.getAllShoesInStock();
        shoesMap.forEach((k, v) -> buttonList.put(new JButton(v.getModel().getName() 
                + " " + v.getColor().getName() + " strl " 
                + v.getSize().getName()), k));
        buttonList.forEach((k, v) -> panel.add(k));
        buttonList.forEach((k, v) -> k.addActionListener(e -> {
            shoeID = buttonList.get(e.getSource());
            changeButtonsToOrders();
        }));
        repaint();
        revalidate();
    }
    
    public void changeButtonsToOrders(){
        buttonList.clear();
        panel.removeAll();
        panel.add(label);
        label.setText("Välj beställning: ");
        
        Customer customer = customerMap.get(customerID);
        ordersMap = r.getOrders(customerID, customer);
        ordersMap.forEach((k, v) -> buttonList.put(new JButton("" + v.getDateCreated()), k));
        buttonList.forEach((k, v) -> panel.add(k));
        buttonList.forEach((k, v) -> k.addActionListener(e -> {
            orderID = buttonList.get(e.getSource());
            changeToResult();
        }));
        JButton newOrder = new JButton("Ny beställning");
        newOrder.addActionListener(e -> {
            orderID = -1;
            changeToResult();
        });
        panel.add(newOrder);
        repaint();
        revalidate();
    }
    
    public void changeToResult(){
        String result = r.addToCart(customerID, shoeID, orderID);
        buttonList.clear();
        panel.removeAll();
        panel.add(label);
        label.setText(result);
        repaint();
        revalidate();
    }
    
    public static void main(String[] args) {
        Repository r = new Repository();
        
        Shoeshop s = new Shoeshop();
        
    }
    

}
