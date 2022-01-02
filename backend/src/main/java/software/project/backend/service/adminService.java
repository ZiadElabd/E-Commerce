package software.project.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import software.project.backend.Database.ProductDAO;
import software.project.backend.Model.Product;
import software.project.backend.Model.builder.Director;
import software.project.backend.sercuirty.Singelton;

import java.util.List;

public class adminService {
    private Director director=new Director();
    @Autowired
    private JdbcTemplate jdbcTemplate=new JdbcTemplate();
    private ProductDAO productOperation=new ProductDAO();
    private Singelton trackingSystem=Singelton.getInstance();
    public boolean addProduct(String sessionID,String dataSent){
        String userName=trackingSystem.checkAcess(sessionID);
        if (userName==null) return false;
        Product product=(Product) director.composeModel("product",dataSent);
        return productOperation.insertProduct(product);
    }
    public boolean UpdateProduct(String sessionID,int productID,String dataSent){
        String userName=trackingSystem.checkAcess(sessionID);
        if (userName==null) return false;
        Product product=(Product) director.composeModel("product",dataSent);
        return productOperation.updateProduct(product,productID);
    }
    public boolean deleteProduct(String sessionID,String productID){
        String userName=trackingSystem.checkAcess(sessionID);
        if (userName==null) return false;
        return productOperation.deleteProduct(0);
    }

    public List<Product> getAllProductByCategroy(String sessionID,String categroy){
        String userName=trackingSystem.checkAcess(sessionID);
        if (userName==null) return null;
        return productOperation.getProductByCategory(categroy);
    }
    public Product getProductByID(String sessionID,int productID){
        String userName=trackingSystem.checkAcess(sessionID);
        if (userName==null) return null;
        return productOperation.getProductByID(productID);
    }

}
