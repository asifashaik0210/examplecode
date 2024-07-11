package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.exception.ResourceNotFound;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(int productId) {
        Product productWithId = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFound("The product id is not found"));
        productRepository.deleteById(productId);
    }

    public Product getProduct(int id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("The product id is not found"));
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product updateProductDetails(int id, Product product) {
        Product productWithId = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("The product id is not found"));

        productWithId.setProduct(product.getProduct());
        productWithId.setDescription(product.getDescription());
        productWithId.setCost(product.getCost());

        return productRepository.save(productWithId);
    }
}
