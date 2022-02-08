package software.project.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import software.project.backend.Model.Cart;
import software.project.backend.Model.Product;
import software.project.backend.sercuirty.Singelton;
import software.project.backend.service.userService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    private userService service=new userService();
    private Singelton trackingSystem=Singelton.getInstance();
    @PostMapping("search/{ID}")
    public ResponseEntity<List<Product>> search(@PathVariable("ID") String sessionID,
                                                @RequestBody String temp){
        System.out.println(temp);
        List<Product> products=service.search(sessionID,temp);
        if(products!=null) return  new ResponseEntity<>(products, HttpStatus.ACCEPTED);
        return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
    }
    @PostMapping("addToCart/{ID}")
    public ResponseEntity<Boolean> addToCart(@PathVariable("ID") String sessionID,
                                             @RequestBody String temp){
        System.out.println(temp);
        if(service.addToCart(sessionID,temp))  return new ResponseEntity<>(true, HttpStatus.OK);
        return new ResponseEntity<>(false, HttpStatus.FORBIDDEN);
    }
    @DeleteMapping("deleteFromCart/{ID}/{productID}")
    public ResponseEntity<Boolean> deleteFromCart(@PathVariable("ID") String sessionID,
                                                  @PathVariable("productID") int productID){
        if(service.deleteFromCart(sessionID,productID))  return new ResponseEntity<>(true, HttpStatus.OK);
        return new ResponseEntity<>(false, HttpStatus.FORBIDDEN);
    }
    @DeleteMapping("deleteCart/{ID}")
    public ResponseEntity<Boolean> deleteCart(@PathVariable("ID") String sessionID){
        if(service.deleteCart(sessionID))  return new ResponseEntity<>(true, HttpStatus.OK);
        return new ResponseEntity<>(false, HttpStatus.FORBIDDEN);
    }
    @GetMapping("/getCart/{ID}")
    public ResponseEntity<List<Cart>> getCart(@PathVariable("ID") String sessionID){
        List<Cart> products=service.getCart(sessionID);
        if(products!=null) return  new ResponseEntity<>(products, HttpStatus.ACCEPTED);
        return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
    }
    @GetMapping("/checkCart/{ID}/{productID}")
    public ResponseEntity<Boolean> checkCart(@PathVariable("ID") String sessionID,
                                             @PathVariable("productID") int productID){
        if(service.checkCart(sessionID,productID)) return  new ResponseEntity<>(true, HttpStatus.ACCEPTED);
        return new ResponseEntity<>(false, HttpStatus.FORBIDDEN);
    }
    @PutMapping("updateCart/{ID}")
    public ResponseEntity<Boolean> updateCart(@PathVariable("ID") String sessionID,
                                              @RequestBody String temp){
        if(service.updateCart(sessionID,temp)) return  new ResponseEntity<>(true, HttpStatus.ACCEPTED);
        return new ResponseEntity<>(false, HttpStatus.FORBIDDEN);
    }

}
