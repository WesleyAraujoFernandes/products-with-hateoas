package br.com.knowledge.products_with_hateoas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.knowledge.products_with_hateoas.entity.Product;
import br.com.knowledge.products_with_hateoas.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<Product> findAll() {
        return productRepository.findAll();
    }
    public Product findById(Long id) {
        if (id == null)
            throw new RuntimeException("ID cannot be null");
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }
    public Product save(Product product) {
        if (product == null)
            throw new RuntimeException("Product cannot be null");
        return productRepository.save(product);
    }
    public void deleteById(Long id) {
        if (id == null)
            throw new RuntimeException("ID cannot be null");
        Product product = findById(id);
        if (product == null)
            throw new RuntimeException("Product not found");
        productRepository.delete(product);
    }
    public void delete(Product product) {
        if (product == null)
            throw new RuntimeException("Product cannot be null");
        productRepository.delete(product);
    }
}
