package software.project.backend.Model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User person = new User();
		person.setUserId(rs.getInt("userId"));
		person.setRole(rs.getBoolean("role"));
		return person;
	}
	
	

}
