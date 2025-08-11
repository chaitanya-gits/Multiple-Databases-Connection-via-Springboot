package com.demo.controller;

import com.demo.entity.ProductDetails;
import com.demo.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    // Create New Product
    @PostMapping
    public ResponseEntity<ProductDetails> createProduct(  @RequestBody ProductDetails productDetails){
        ProductDetails createproduct = productService.createProduct(productDetails);
        return new ResponseEntity<>(createproduct, HttpStatus.CREATED);
    }

    // Get the All Products
    @GetMapping
    public ResponseEntity<List<ProductDetails>> getAllProduct(){
        List<ProductDetails> products = productService.getAllProducts();
        return new ResponseEntity<>(products,HttpStatus.OK);
    }

    // Get product by id
    @GetMapping("/{id}")
    public ResponseEntity<ProductDetails> getProductById(@PathVariable int id){
        ProductDetails product = productService.getById(id);
//        if (product!=null){
//            return new ResponseEntity<>(product,HttpStatus.OK);
//        }else{
            return new ResponseEntity<>(product,HttpStatus.OK);
//        }
    }


    // Update product by id
    @PutMapping("/{id}")
    public ResponseEntity<ProductDetails> updateProductById(@PathVariable int id, @RequestBody ProductDetails productDetails){
        ProductDetails updateproduct = productService.updateById(id,productDetails);
        if (updateproduct!=null){
            return new ResponseEntity<>(updateproduct,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(updateproduct,HttpStatus.NOT_FOUND);
        }
    }

    // delete product details by id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id){
        ProductDetails deleteProduct = productService.getById(id);
        if (deleteProduct!=null){
            productService.deleteById(id);
            return new ResponseEntity<>("Product delete successfully",HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Product Not Found",HttpStatus.NOT_FOUND);
        }
    }
}
