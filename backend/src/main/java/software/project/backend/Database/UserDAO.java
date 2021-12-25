package software.project.backend.Database;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import software.project.backend.Model.User;

public class UserDAO {


	private final String SQL_INSERT_USER = "INSERT INTO USER (userName,password,firstName,lastName,Address,Phone,role) VALUES (?,?,?,?,?,?,?)";
	private final String SQL_SELECT_BY_USERNAME = "SELECT * FROM USER WHERE userName=?";
	private final String SQL_SELECT_BY_USER_PASS = "SELECT * FROM USER WHERE userName=? AND password=?";
	private final String SQL_GET_ALL = "select * from people";
	private final String SQL_INSERT_PERSON = "insert into people(id, first_name, last_name, age) values(?,?,?,?)";
	private final String SQL_FIND_USER = "select * from user where userName = ?";
	 private JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
	 
	 public UserDAO() {
	 }
	 @Bean
	 @Primary
	 public static DataSource dataSource() {
		 return DataSourceBuilder
				 .create()
				 .username("sql4460814")
				 .password("Ruwqt9etyE")
				 .url("jdbc:mysql://sql4.freemysqlhosting.net:3306/sql4460814")
				 .driverClassName("com.mysql.cj.jdbc.Driver")
				 .build();
	 }
	

	public boolean insertUser(User user) {

		System.out.println(user.getUserName()+
				" " +user.getPassword()+
				" "+user.getFirstName()+
				" "+user.getLastName()+
				" "+user.getAddress()+
				" "+user.getPhone()
		);
	        int result = jdbcTemplate.update(SQL_INSERT_USER,user.getUserName(),user.getPassword(),user.getFirstName(),user.getLastName(),user.getAddress(),user.getPhone(),user.getRole());
	         
	        if (result > 0) {
	            System.out.println("A new row has been inserted.");
	            return true ;
		        }
	        return false ;
		}
	
	public boolean findByUserName(String u) {
	    try {
	      User user = jdbcTemplate.queryForObject(SQL_SELECT_BY_USERNAME,
				  BeanPropertyRowMapper.newInstance(User.class), u);
	      return true;
	    } catch (IncorrectResultSizeDataAccessException e) {
			System.out.println("false");
	      return false;
	    }
	  }
	
	public User checkSignIn(String userName,String Password) {
	    try {
	      User user = jdbcTemplate.queryForObject(SQL_SELECT_BY_USER_PASS,
	          BeanPropertyRowMapper.newInstance(User.class), userName ,Password);
	      return user;
	    } catch (IncorrectResultSizeDataAccessException e) {
	      return null;
	    }
	  }
	
	
	
	
	
	
	
	

}
