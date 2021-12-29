package software.project.backend.Database;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import software.project.backend.Model.Product;
import software.project.backend.Model.User;
import software.project.backend.Model.UserMapper;

public class ProductDAO {


	private final String SQL_INSERT_PRODUCT = "INSERT INTO PRODUCT (categoryName,name,description,price,quantity,discount,image) VALUES (?,?,?,?,?,?,?)";
	private final String SQL_UPDATE_PRODUCT = "UPDATE PRODUCT SET name=?, description=?, price=?, discount=? WHERE productId=?";
	private JdbcTemplate jdbcTemplate = new JdbcTemplate(Source.getDataSource());

	public ProductDAO() { }


	public boolean deleteProduct(String n) {

		int result = jdbcTemplate.update(Commands.DELETE_PRODUCT(),n);

		if (result > 0) {
			System.out.println("A new has been deleted");
			return true ;
		}
		return false ;
	}


	public boolean insertProduct(Product p) {

		System.out.println(p.getImage());
		int result = jdbcTemplate.update(Commands.INSERT_PRODUCT(),
				p.getCategoryName(),
				p.getName(),
				p.getDescription(),
				p.getPrice() ,
				p.getQuantity(),
				p.getDiscount(),
				p.getImage());

		if (result > 0) {
			System.out.println("A new row has been inserted.");
			return true ;
		}
		return false ;
	}
	
	public boolean updateProduct(Product p) {

		int result = jdbcTemplate.update(Commands.UPDATE_PRODUCT(),
				p.getCategoryName(),
				p.getName(),
				p.getDescription(),
				p.getPrice() ,
				p.getQuantity(),
				p.getDiscount(),
				null,
				p.getProductId());
		if (result > 0) {
            System.out.println("A new row has been updated.");
            return true ;
		}
        return false ;
	}

	
	
	
	
	
	
	
	

}
