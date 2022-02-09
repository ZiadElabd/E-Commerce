package software.project.backend.service;

import org.json.JSONException;
import org.json.JSONObject;
import software.project.backend.Database.ProductDAO;
import software.project.backend.Model.Cart;
import software.project.backend.Model.Product;
import software.project.backend.Model.order;
import software.project.backend.sercuirty.Singelton;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class userService {
    private ProductDAO productDAO=new ProductDAO();
    private Singelton trackingSystem=Singelton.getInstance();
    public List<Product> search(String sessionID,String dataSent){
        String userName=trackingSystem.checkAcess(sessionID);
        if (userName==null) return null;
        String cateogry="";
        String searchText="";
        try {
            JSONObject obj = new JSONObject(dataSent);
            cateogry=obj.getString("categoryName");
            searchText=obj.getString("searchText");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return productDAO.searchWithName(searchText,cateogry);
    }
    public boolean addToCart(String sessionID,String dataSent){
        String userName=trackingSystem.checkAcess(sessionID);
        if (userName==null) return false;
        int productID = 0;
        int noOfCopies = 0;
        try {
            JSONObject obj = new JSONObject(dataSent);
            productID=obj.getInt("productID");
            noOfCopies=obj.getInt("noOfCopies");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return productDAO.insertToCart(userName,productID,noOfCopies);
    }
    public boolean deleteFromCart(String sessionID,int productID ){
        String userName=trackingSystem.checkAcess(sessionID);
        if (userName==null) return false;
        return productDAO.deleteFromCart(productID,userName);
    }
    public boolean deleteCart(String sessionID){
        String userName=trackingSystem.checkAcess(sessionID);
        if (userName==null) return false;
        return productDAO.clearCart(userName);
    }
    public List<Cart> getCart(String sessionID){
        String userName=trackingSystem.checkAcess(sessionID);
        if (userName==null) return null;
        return productDAO.getCart(userName);
    }
    public boolean updateCart(String sessionID,String dataSent){
        String userName=trackingSystem.checkAcess(sessionID);
        if (userName==null) return false;
        int productID = 0;
        int noOfCopies = 0;
        try {
            JSONObject obj = new JSONObject(dataSent);
            productID=obj.getInt("productID");
            noOfCopies=obj.getInt("noOfCopies");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return productDAO.updateCart(userName,productID,noOfCopies);
    }
   public  boolean checkCart(String sessionID,int productID){
       String userName=trackingSystem.checkAcess(sessionID);
       if (userName==null) return false;
       return productDAO.isInCart(userName,productID);
   }
   public boolean addOrder(String sessionID,String dataSent){
       String userName=trackingSystem.checkAcess(sessionID);
       if (userName==null) return false;
       order order=new order();
       try {
           JSONObject obj = new JSONObject(dataSent);
           order.setTotalPrice(obj.getDouble("totalPrice"));
           order.setNoOfItems(obj.getInt("numOfItems"));
           DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
           LocalDateTime now = LocalDateTime.now();
           order.setDate(dtf.format(now));
       } catch (JSONException e) {
           e.printStackTrace();
       }
       return productDAO.insertOrder(order);


   }

}
