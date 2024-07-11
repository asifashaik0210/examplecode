package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService productService;
    @PostMapping("/product")
    public ResponseEntity<Product> postProduct(@RequestBody Product product){
        Product product1 = productService.addProduct(product);
        return new ResponseEntity<>(product1, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        productService.deleteProduct(id);
        return new ResponseEntity<>("product is deleted",HttpStatus.OK);

    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id){
        Product product = productService.getProduct(id);
        return new ResponseEntity<>(product,HttpStatus.OK);

    }
    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAll(){
        List<Product> allProducts = productService.getAllProducts();
        return new ResponseEntity<>(allProducts,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id ,@RequestBody Product product ){
        Product product1 = productService.updateProductDetails(id,product);
        return new ResponseEntity<>(product1,HttpStatus.OK);
    }
}
