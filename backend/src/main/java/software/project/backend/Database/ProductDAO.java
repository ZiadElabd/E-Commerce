package software.project.backend.Database;

import org.springframework.jdbc.core.JdbcTemplate;

import software.project.backend.Model.Product;

public class ProductDAO {

	private JdbcTemplate jdbcTemplate = new JdbcTemplate(Source.getDataSource());

	public ProductDAO() {

	}

	public boolean insertProduct(Product p) {

		int result = jdbcTemplate.update(Commands.INSERT_PRODUCT(),
				p.getCategoryName(),
				p.getName(),
				p.getDescription(),
				p.getPrice() ,
				p.getQuantity(),
				p.getDiscount(),
				p.getImage());

		if (result > 0) {
			System.out.println("A new product has been inserted.");
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

	public boolean deleteProduct(String name) {

		int result = jdbcTemplate.update(Commands.DELETE_PRODUCT(), name);

		if (result > 0) {
			System.out.println("A new has been deleted");
			return true ;
		}
		return false ;
	}

}
