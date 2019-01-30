package shoeshop;

import java.io.FileInputStream;
import java.sql.*;
import java.util.*;

public class Repository {
    private Properties p = new Properties();
    
    public Repository(){
        
        try{
           p.load(new FileInputStream("src/shoeshop/Settings.properties")); 
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public Map getAllCustomers(Map customerMap){
        
        Map<Integer, CityAddress> addressMap = getAllCityAddresses();
        
        try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoeshop2", 
                p.getProperty("username"), p.getProperty("password"));
                Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from customer")){
                
            while (rs.next()) {
                customerMap.put(rs.getInt("id"), 
                        new Customer(rs.getInt("id"), rs.getString("firstname"), 
                                rs.getString("lastname"), rs.getString("streetaddress"), 
                                addressMap.get("" + rs.getInt("addressID")), 
                                rs.getTimestamp("created"), rs.getTimestamp("lastUpdated")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return customerMap;
    }
    
    public Map getAllCityAddresses(){
        
        Map<Integer, CityAddress> addressMap = new HashMap();
        
        try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoeshop2", p.getProperty("username"), p.getProperty("password"));
                Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from address")){
                
            while (rs.next()) {
                addressMap.put(rs.getInt("id"), new CityAddress(rs.getInt("id"), rs.getInt("zipcode"), rs.getString("city"), rs.getTimestamp("created"), rs.getTimestamp("lastUpdated")));
            }
                
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return addressMap;
    }
    
    public Map getAllShoesInStock(){
        Map<Integer, Shoe> shoesMap = new HashMap();
        Map<Integer, Model> modelsMap = getAllModels();
        Map<Integer, Size> sizesMap = getAllSizes();
        Map<Integer, Color> colorsMap = getAllColors();
        
        try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoeshop2", 
                p.getProperty("username"), p.getProperty("password"));
                Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from shoe where inStock > 0")){
                
            while (rs.next()) {
                shoesMap.put(rs.getInt("id"), new Shoe(rs.getInt("id"), sizesMap.get(rs.getInt("sizeID")), 
                        colorsMap.get(rs.getInt("colorID")), modelsMap.get(rs.getInt("modelID")), rs.getInt("inStock"),
                        rs.getTimestamp("created"), rs.getTimestamp("lastUpdated")));
            }
                
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return shoesMap;
    }
    
    public Map getAllSizes(){
        Map<Integer, Size> sizeMap = new HashMap();
        
        try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoeshop2", 
                p.getProperty("username"), p.getProperty("password"));
                Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from size")){
                
            while (rs.next()) {
                sizeMap.put(rs.getInt("id"), new Size(rs.getInt("id"), rs.getString("name"), 
                        rs.getTimestamp("created"), rs.getTimestamp("lastUpdated")));
            }
                
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return sizeMap;
    }
    
    public Map getAllColors(){
        Map<Integer, Color> colorsMap = new HashMap();
        
        try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoeshop2", 
                p.getProperty("username"), p.getProperty("password"));
                Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from color")){
                
            while (rs.next()) {
                colorsMap.put(rs.getInt("id"), new Color(rs.getInt("id"), rs.getString("name"), rs.getString("description"),
                        rs.getTimestamp("created"), rs.getTimestamp("lastUpdated")));
            }
                
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return colorsMap;
    }
    
    public Map getAllModels(){
        Map<Integer, Model> modelsMap = new HashMap();
        Map<Integer, Brand> brandsMap = getAllBrands();
        
        try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoeshop2", 
                p.getProperty("username"), p.getProperty("password"));
                Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from model")){
                
            while (rs.next()) {
                modelsMap.put(rs.getInt("id"), new Model(rs.getInt("id"), rs.getString("name"), 
                        rs.getDouble("price"), brandsMap.get(rs.getString("brandID")), 
                        rs.getTimestamp("created"), rs.getTimestamp("lastUpdated")));
            }
                
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return modelsMap;
    }
    
    public Map getAllBrands(){
        Map<Integer, Brand> brandsMap = new HashMap();
        
        try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoeshop2", 
                p.getProperty("username"), p.getProperty("password"));
                Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from brand")){
                
            while (rs.next()) {
                brandsMap.put(rs.getInt("id"), new Brand(rs.getInt("id"), rs.getString("name"), 
                        rs.getTimestamp("created"), rs.getTimestamp("lastUpdated")));
            }
                
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return brandsMap;
    }
    
    public Map getOrders(int id, Customer customer){
        Map<Integer, Order> ordersMap = new HashMap();
        
        try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoeshop2", 
                p.getProperty("username"), p.getProperty("password"));
                Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from orders where customerId = " + id + " and shipped = false")){
                
            while (rs.next()) {
                ordersMap.put(rs.getInt("id"), new Order(rs.getInt("id"), customer, 
                        rs.getBoolean("shipped"), rs.getTimestamp("created"), 
                        rs.getTimestamp("lastUpdated")));
            }
                
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return ordersMap;
    }

    public String addToCart(int customerID, int shoeID, int orderID){
        String result = "";
        
        try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoeshop2", 
                p.getProperty("username"), p.getProperty("password"));
                CallableStatement stm = con.prepareCall("call addToCart(" + customerID + ", " + shoeID + ", " +orderID + ")");
                ){
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                result = rs.getString("error");
            }
            if (!result.equals("")) {
                return result;
            }
              
        }catch (SQLException se){
            result = "Något gick fel";
            System.out.println(se.getMessage());
            
        } catch (Exception e) {
            result = "Något gick fel";
            e.printStackTrace();
        }
        
        return "Varan är tillagd";
    }
}
