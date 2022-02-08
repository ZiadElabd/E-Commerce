package software.project.backend.Database;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import software.project.backend.Model.Cart;
import software.project.backend.Model.Product;
import software.project.backend.Model.order;

import java.util.List;

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

	public boolean updateProduct(Product p, int productId) {

		int result = jdbcTemplate.update(Commands.UPDATE_PRODUCT(),
				p.getCategoryName(),
				p.getName(),
				p.getDescription(),
				p.getPrice() ,
				p.getQuantity(),
				p.getDiscount(),
				p.getImage(),
				productId);
		if (result > 0) {
			System.out.println("A new row has been updated.");
			return true ;
		}
		return false ;
	}

	public Product getProductByID(int ID) {
		Product product = (Product) jdbcTemplate.queryForObject(Commands.GET_PRODUCT_BY_ID(),
				new BeanPropertyRowMapper(Product.class), ID);
		return product;
	}

	public List<Product> getProductByCategory(String categoryName) {
		List<Product> products = jdbcTemplate.query(Commands.GET_PRODUCTS_BY_CATEGORY(),
				new BeanPropertyRowMapper(Product.class),
				categoryName);
		return products;
	}

	public List<Product> getAllProduct() {
		List<Product> products = jdbcTemplate.query(Commands.GET_ALL_PRODUCTS(),
				new BeanPropertyRowMapper(Product.class));
		return products;
	}

	public boolean deleteProduct(int productId) {

		int result = jdbcTemplate.update(Commands.DELETE_PRODUCT(), productId);

		if (result > 0) {
			System.out.println("A new has been deleted");
			return true ;
		}
		return false ;
	}
	
	public List<Product> searchWithName(String title, String cateogry) {
		List<Product> res = (List<Product>) jdbcTemplate.query(Commands.searchWithName(title),
				new BeanPropertyRowMapper(Product.class), cateogry);
		return res;
	}
	
	public boolean updateCart(String userName, int productId, int newCopies) {
		jdbcTemplate.update(Commands.updateCart(), newCopies ,userName, productId);
		return true;
	}

	public boolean isInCart(String userName, int productId) {
		try {
			Integer n = jdbcTemplate.queryForObject(Commands.isInCart(),
					Integer.class,
					userName, productId);
			return (n != null) && (n > 0);
		} catch (IncorrectResultSizeDataAccessException e) {
			System.out.println("Exception in checking userName");
			return false;
		}
	}
	
	public boolean insertToCart(String userName, int productId, int noOpCopies) {
		 jdbcTemplate.update(Commands.insertToCart(), userName, productId, noOpCopies);
		 return true;
	}
	
	public boolean deleteFromCart(int productId, String userName) {

		int result = jdbcTemplate.update(Commands.removeFromCart(), productId, userName);

		if (result > 0) {
			System.out.println("A row has been deleted");
			return true ;
		}
		return false ;
	}
	
	public boolean clearCart(String userName) {

		int result = jdbcTemplate.update(Commands.clearCart(), userName);

		if (result > 0) {
			System.out.println("Cart is Empty");
			return true ;
		}
		return false ;
	}
	
	public List<Cart> getCart(String userName) {
		return jdbcTemplate.query(Commands.getCart(), new BeanPropertyRowMapper(Cart.class), userName);
	}
	
	public List<order> getOrders() {
		return jdbcTemplate.query(Commands.getOrders(), new BeanPropertyRowMapper(order.class));
	}
	
	public boolean insertOrder(order o) {

		int result = jdbcTemplate.update(Commands.INSERT_ORDER(),
				o.getNumOfItems(),
				o.getDate(),
				o.getTotalPrice());

		if (result > 0) {
			System.out.println("A new product has been inserted.");
			return true ;
		}
		return false ;
	}

	
	
	
	

}
