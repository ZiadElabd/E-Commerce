package software.project.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import software.project.backend.service.adminService;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {
    adminService service=new adminService();
    @PostMapping("/addProduct")
    public ResponseEntity<Boolean> addProductController(@RequestBody String temp){
        if (service.addProduct(temp)) return new ResponseEntity<>(true, HttpStatus.OK);
        return new ResponseEntity<>(false, HttpStatus.FORBIDDEN);
    }
    @PutMapping("/updateProduct/{productID}")
    public ResponseEntity<Boolean> updateProductController(@PathVariable("productID") int productID,
                                                           @RequestBody String temp){
        if (service.UpdateProduct(productID,temp)) return new ResponseEntity<>(true, HttpStatus.OK);
        return new ResponseEntity<>(false, HttpStatus.FORBIDDEN);
    }
    @DeleteMapping ("/{productID}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable("productID") String temp){
        System.out.println(temp);
        if(service.deleteProduct(temp)) return new ResponseEntity<>(true, HttpStatus.ACCEPTED);
        return new ResponseEntity<>(false, HttpStatus.FORBIDDEN);
    }

}
