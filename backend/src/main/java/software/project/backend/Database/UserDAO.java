package software.project.backend.Database;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import software.project.backend.Database.CustomMappers.SignInMapper;
import software.project.backend.Model.User;

public class UserDAO {

	private final JdbcTemplate jdbcTemplate = new JdbcTemplate(Source.getDataSource());

	public UserDAO() {
	}

	public boolean insertUser(User user) {

		int result = jdbcTemplate.update(Commands.INSERT_USER(),
				user.getUserName(),
				user.getPassword(),
				user.getFirstName(),
				user.getLastName(),
				user.getAddress(),
				user.getPhone(),
				user.getRole());

		if (result > 0) {
			System.out.println("A new row has been inserted.");
			return true ;
		}
		return false ;
	 }

	public boolean isUserNameExist(String userName) {
		try {
			Integer n = jdbcTemplate.queryForObject(Commands.SELECT_BY_USERNAME(),
					Integer.class,
					userName);

			return (n != null) && (n > 0);
		} catch (IncorrectResultSizeDataAccessException e) {
			System.out.println("Exception in checking userName");
			return false;
		}
	}
	
	public User checkSignIn(String userName,String Password) {
	    try {
			return jdbcTemplate.queryForObject(Commands.SELECT_BY_USER_PASS(),
					new SignInMapper(),
					userName ,
					Password);
	    } catch (IncorrectResultSizeDataAccessException e) {
			return null;
	    }
	}

	public boolean changePassword(String userName,String password){
		int result = jdbcTemplate.update(Commands.CHANGE_PASSWORD(), password, userName);

		if (result > 0) {
			System.out.println("Password is changed");
			return true ;
		}
		return false ;
	}

	public boolean deleteAllCustomers(){
		jdbcTemplate.update(Commands.DELETE_ALL_CUSTOMERS());
		return true ;
	}

}
