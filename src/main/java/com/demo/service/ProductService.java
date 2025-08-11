package com.demo.service;

import com.demo.entity.ProductDetails;
import com.demo.exception.ProductNotFoundException;
import com.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Create a products
    public ProductDetails createProduct(ProductDetails productDetails){
        return productRepository.save(productDetails);
    }

    //  Get all products
    public List<ProductDetails> getAllProducts(){
        return productRepository.findAll();
    }

    // Get particular product by Id
    public ProductDetails getById(int id){
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product Not Found with this "+ id));
        //() -> new ProductNotFoundException("product not found with the " + id));
    }

    // Delete by Id
    public void deleteById(int id){
        productRepository.deleteById(id);
    }

    // Update by Id
    public ProductDetails updateById(int id, ProductDetails productDetails){
        ProductDetails product = getById(id);
        if (product == null){
            return null;
        }
        product.setProductName(productDetails.getProductName());
        product.setProductPrice(productDetails.getProductPrice());
        return productRepository.save(product);
    }
}
