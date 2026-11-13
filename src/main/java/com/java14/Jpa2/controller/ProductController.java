package com.java14.Jpa2.controller;

import com.java14.Jpa2.request.InsertProductRequest;
import com.java14.Jpa2.request.UpdateProductRequest;
import com.java14.Jpa2.respond.BaseRespond;
import com.java14.Jpa2.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductServices productServices;
    @PostMapping
    public ResponseEntity<?> addProduct(@RequestBody InsertProductRequest request){

        return ResponseEntity.ok(productServices.addProduct(request));
    }
    @GetMapping
    public ResponseEntity<?> getAllProduct(){
        return ResponseEntity.ok(productServices.getAllProducts());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getProduct(@PathVariable int id){
        return ResponseEntity.ok(productServices.getProduct(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody UpdateProductRequest request,@PathVariable int id){
        return ResponseEntity.ok(productServices.updateProduct(request,id));
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<?> deleteProduct(@PathVariable int id){
        productServices.deleteProduct(id);
        BaseRespond baseRespond= new BaseRespond();
        baseRespond.setMessage("Xoá thành cong");
        return ResponseEntity.ok(baseRespond);
    }
}
