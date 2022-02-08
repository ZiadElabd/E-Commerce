package software.project.backend.Database;

public class Commands {

    public static String INSERT_USER(){
        return "INSERT INTO USER " +
                "(userName, password, firstName, lastName, Address, Phone, role) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
    }

    public static String UPDATE_USER_SETTINGS(){
        return "UPDATE USER SET firstName = ?, lastName = ?, Address = ?, Phone = ? " +
                " WHERE userName = ? ";
    }


    public static String SELECT_BY_USERNAME(){
        return "SELECT COUNT(*) FROM USER WHERE userName = ? ";
    }

    public static String GET_USER_DATA(){
        return "SELECT * FROM USER WHERE userName = ? ";
    }


    public static String SELECT_BY_USER_PASS(){
        return "SELECT * FROM USER WHERE userName = ? AND password = ?";
    }

    public static String CHANGE_PASSWORD(){
        return "UPDATE USER SET password = ? WHERE userName = ?";
    }

    public static String GET_ADMINS(){
        return "SELECT userName FROM USER WHERE role != 0 AND role != 1";
    }

    public static String DELETE_ADMIN(){
        return "DELETE FROM USER WHERE role != 1  AND userName = ?; ";
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
                "SET CategoryName = ?, name = ?, description = ?, price = ?, quantity = ?, discount = ?, image = ?" +
                "WHERE productId = ?";
    }


    public static String GET_PRODUCT_BY_ID(){
        return "SELECT * FROM PRODUCT WHERE productId = ?" ;
    }

    public static String GET_PRODUCTS_BY_CATEGORY(){
        return "SELECT * FROM PRODUCT where CategoryName = ?" ;
    }

    public static String GET_ALL_PRODUCTS(){
        return "SELECT * FROM PRODUCT" ;
    }

    public static String DELETE_PRODUCT(){
        return "DELETE FROM PRODUCT " +
                "WHERE productId = ?";
    }
    
    public static String searchWithName(String text) {
        return "SELECT * FROM product AS B WHERE B.name LIKE  '%" + text + "%' AND B.categoryName=? ";
    }
    
    public static String getCart() {
        return " SELECT B.productId,B.name , B.description, B.price , C.noOfCopies ,B.image  FROM Book AS B JOIN Cart AS C ON C.productId = B.productId WHERE C.userName = ? ";
    }

    public static String insertToCart() {
        return "INSERT INTO CART (userName ,productId , noOfCopies) VALUES (?,?,?)";
    }

    public static String isInCart() {
        return "SELECT Count(*) FROM Cart AS C WHERE C.userName = ? AND C.productId = ? ";
    }

    public static String updateCart() {
        return "UPDATE Cart AS C SET C.noOfCopies = ? WHERE C.userName = ? AND C.productId = ? ";
    }
    
    public static String removeFromCart(){
        return "DELETE FROM CART WHERE productId = ?  AND userName = ?; ";
    }
    
    public static String clearCart(){
        return "DELETE FROM CART WHERE userName = ?; ";
    }


}
