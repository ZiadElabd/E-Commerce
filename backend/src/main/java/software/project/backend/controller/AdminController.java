package software.project.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import software.project.backend.service.adminService;

@RestController
@CrossOrigin
public class AdminController {
    adminService service=new adminService();
    @PostMapping("/admin/addProduct")
    public ResponseEntity<Boolean> addProductController(@RequestBody String temp){
        if (service.addProduct(temp)) return new ResponseEntity<>(true, HttpStatus.OK);
        return new ResponseEntity<>(false, HttpStatus.FORBIDDEN);
    }
    @PutMapping("/admin/updateProduct")
    public ResponseEntity<Boolean> updateProductController(@RequestBody String temp){
        if (service.UpdateProduct(temp)) return new ResponseEntity<>(true, HttpStatus.OK);
        return new ResponseEntity<>(false, HttpStatus.FORBIDDEN);
    }
    @DeleteMapping ("/admin/{productName}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable("productName") String temp){
        System.out.println(temp);
        if(service.deleteProduct(temp)) return new ResponseEntity<>(true, HttpStatus.ACCEPTED);
        return new ResponseEntity<>(false, HttpStatus.FORBIDDEN);
    }

}
