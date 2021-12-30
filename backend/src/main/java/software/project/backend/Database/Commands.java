package software.project.backend.Database;

public class Commands {

    private final String SQL_GET_ALL = "select * from people";
    private final String SQL_INSERT_PERSON = "insert into people(id, first_name, last_name, age) values(?,?,?,?)";
    private final String SQL_FIND_USER = "select * from user where userName = ?";

    public static String INSERT_USER(){
        return "INSERT INTO USER " +
                "(userName, password, firstName, lastName, Address, Phone, role) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
    }


    public static String SELECT_BY_USERNAME(){
        return "SELECT COUNT(*) FROM USER WHERE userName = ? ";
    }


    public static String SELECT_BY_USER_PASS(){
        return "SELECT * FROM USER WHERE userName = ? AND password = ?";
    }

    public static String CHANGE_PASSWORD(){
        return "UPDATE USER SET password = ? WHERE userName = ?";
    }

    public static String DELETE_ALL_CUSTOMERS(){
        return "DELETE FROM USER WHERE role != 1; ";
    }

    public static String INSERT_PRODUCT(){
        return "INSERT INTO PRODUCT " +
                "(categoryName, name, description, price, quantity, discount, image) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
    }

    public static String UPDATE_PRODUCT(){
        return "UPDATE PRODUCT " +
                "SET name = ?, description = ?, price = ?, discount = ? " +
                "WHERE productId = ?";
    }

    public static String GET_ALL_PRODUCTS(){
        return "SELECT * FROM PRODUCT" ;
    }

    public static String DELETE_PRODUCT(){
        return "DELETE FROM PRODUCT " +
                "WHERE name = ?";
    }

}
