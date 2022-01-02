package software.project.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import software.project.backend.Model.Product;
import software.project.backend.sercuirty.Singelton;
import software.project.backend.service.adminService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {
    private adminService service=new adminService();
    private Singelton trackingSystem=Singelton.getInstance();
    @PostMapping("/addProduct")
    public ResponseEntity<Boolean> addProductController(@RequestBody String temp,
                                                        @PathVariable("ID") String seesionID){
        if (service.addProduct(seesionID,temp)) return new ResponseEntity<>(true, HttpStatus.OK);
        return new ResponseEntity<>(false, HttpStatus.FORBIDDEN);
    }
    @PutMapping("/updateProduct/{productID}/{ID}")
    public ResponseEntity<Boolean> updateProductController(@PathVariable("productID") int productID,
                                                           @RequestBody String temp,
                                                           @PathVariable("ID") String seesionID){
        if (service.UpdateProduct(seesionID,productID,temp)) return new ResponseEntity<>(true, HttpStatus.OK);
        return new ResponseEntity<>(false, HttpStatus.FORBIDDEN);
    }
    @DeleteMapping ("/{productID}/{ID}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable("productID") String temp,
                                                 @PathVariable("ID") String seesionID){
        System.out.println(temp);
        if(service.deleteProduct(seesionID,temp)) return new ResponseEntity<>(true, HttpStatus.ACCEPTED);
        return new ResponseEntity<>(false, HttpStatus.FORBIDDEN);
    }
    @GetMapping("/getProducts/{categroyName}/{ID}")
    public ResponseEntity<List<Product>> getProductsByCategroy(@PathVariable("categroyName") String categroyName,
                                                               @PathVariable("ID") String seesionID){
        List<Product> ProductsByCategroy=service.getAllProductByCategroy(seesionID,categroyName);
        if (ProductsByCategroy!=null) return  new ResponseEntity<>(ProductsByCategroy, HttpStatus.ACCEPTED);
        return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
    }
    @GetMapping("/getProduct/{productID}/{ID}")
    public ResponseEntity<Product> getProduct(@PathVariable("productID") int productID,
                                              @PathVariable("ID") String seesionID){
        Product result=service.getProductByID(seesionID,productID);
        if (result!=null) return  new ResponseEntity<>(result, HttpStatus.ACCEPTED);
        return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
    }

}
