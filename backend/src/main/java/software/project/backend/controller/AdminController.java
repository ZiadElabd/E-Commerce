package software.project.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import software.project.backend.Model.Product;
import software.project.backend.Model.User;
import software.project.backend.Model.order;
import software.project.backend.sercuirty.Singelton;
import software.project.backend.service.adminService;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {
    private adminService service=new adminService();
       @PostMapping("/addProduct/{ID}")
    public ResponseEntity<Boolean> addProductController(@RequestBody String temp,
                                                        @PathVariable("ID") String seesionID){
        System.out.println(temp);
        if (service.addProduct(seesionID,temp)) return new ResponseEntity<>(true, HttpStatus.OK);
        return new ResponseEntity<>(false, HttpStatus.FORBIDDEN);
    }
    @PutMapping("/updateProduct/{productID}/{ID}")
    public ResponseEntity<Boolean> updateProductController(@PathVariable("productID") int productID,
                                                           @RequestBody String temp,
                                                           @PathVariable("ID") String seesionID){
        System.out.println(temp);
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
    @GetMapping("/getSetting/{ID}")
    public ResponseEntity<User> getSetting( @PathVariable("ID") String seesionID){
        User user=service.getAdminInfo(seesionID);
        if (user!=null) return  new ResponseEntity<>(user, HttpStatus.ACCEPTED);
        return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
    }
    @GetMapping("/getAdmins/{ID}")
    public ResponseEntity<List<String>> getAdmins(@PathVariable("ID") String seesionID){
        ArrayList<String> admins= (ArrayList<String>) service.getAllAdmins(seesionID);
        if (admins!=null) return  new ResponseEntity<>(admins, HttpStatus.ACCEPTED);
        return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
    }
    @PutMapping("/updateAdmin/{ID}")
    public ResponseEntity<Boolean> updateAdmin(@PathVariable("ID") String seesionID,
                                               @RequestBody String temp){
        System.out.println(seesionID+"  "+temp);
        if (service.updateAdminInfo(seesionID,temp)) return  new ResponseEntity<>(true, HttpStatus.ACCEPTED);
        return new ResponseEntity<>(false, HttpStatus.FORBIDDEN);
    }
    @PostMapping("/addAdmin/{ID}")
    public ResponseEntity<Boolean> addAdmin(@PathVariable("ID") String seesionID,
                                            @RequestBody String temp){
        System.out.println(temp);
        if (service.addAdmin(seesionID,temp)) return  new ResponseEntity<>(true, HttpStatus.ACCEPTED);
        return new ResponseEntity<>(false, HttpStatus.FORBIDDEN);
    }
    @DeleteMapping("/deleteAdmin/{ID}/{AdminName}")
    public ResponseEntity<Boolean> deleteAdmin(@PathVariable("ID") String seesionID,
                                               @PathVariable("AdminName") String AdminName){

        if(service.deleteAdmin(seesionID,AdminName)) return  new ResponseEntity<>(true, HttpStatus.ACCEPTED);
        return new ResponseEntity<>(false, HttpStatus.FORBIDDEN);
    }
    @PostMapping("/changePassword/{ID}")
    public ResponseEntity<Boolean> changePassword(@PathVariable("ID") String sessionID,
                                                  @RequestBody String temp){
        System.out.println(temp);
        if(service.changePassword(sessionID,temp)) return  new ResponseEntity<>(true, HttpStatus.ACCEPTED);
        return new ResponseEntity<>(false, HttpStatus.FORBIDDEN);
    }
    @GetMapping("/getOrders/{ID}")
    public ResponseEntity<List<order>> getOrders(@PathVariable("ID") String sessionID){
        System.out.println(sessionID);
        List<order> orders=service.getAllorders(sessionID);
        if (orders!=null) return  new ResponseEntity<>(orders, HttpStatus.ACCEPTED);
        return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);

    }



}
