package software.project.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import software.project.backend.Database.ProductDAO;
import software.project.backend.Model.Product;
import software.project.backend.Model.builder.Director;

public class adminService {
    private Director director=new Director();
    @Autowired
    private JdbcTemplate jdbcTemplate=new JdbcTemplate();
    private ProductDAO productOperation=new ProductDAO();
    public boolean addProduct(String dataSent){
        Product product=(Product) director.composeModel("product",dataSent);
        return productOperation.insertProduct(product);
    }
    public boolean UpdateProduct(String dataSent){
        Product product=(Product) director.composeModel("product",dataSent);
        return productOperation.updateProduct(product,"");
    }
    public boolean deleteProduct(String name){
        return productOperation.deleteProduct(name);
    }
}
