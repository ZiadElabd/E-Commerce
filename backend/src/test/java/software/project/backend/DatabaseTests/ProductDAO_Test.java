package software.project.backend.DatabaseTests;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import software.project.backend.Database.ProductDAO;
import software.project.backend.Model.Product;
import software.project.backend.Model.builder.Director;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ProductDAO_Test {

    private final Director director = new Director();
    private ProductDAO productDAO = new ProductDAO();

    @Test
    void insertProductTest() {
        String dataSent = "{\n" +
                "   \"name\":\"apple\",\n" +
                "    \"categoryName\":\"Fruits\",\n" +
                "    \"description\":\"apple is healthy\",\n" +
                "    \"price\":\"12\",\n" +
                "    \"amount\":\"10\",\n" +
                "    \"discount\":\"3\",\n" +
                "    \"image\":\"null\"\n" +
                "}";
        System.out.println(dataSent);
        Product product = (Product) director.composeModel("product",dataSent);
        System.out.println(product);
        assertTrue(productDAO.insertProduct(product));

    }

    @Test
    void getProductByCategoryTest() {
        List<Product> products = productDAO.getProductByCategory("none");
        for (Product product : products) {
            System.out.println(product.getCategoryName() + "  " + product.getName());
        }

    }

    @Test
    void deleteProductTest() {
        assertTrue(productDAO.deleteProduct("apple"));

    }

}
