package br.com.knowledge.stockonyou.controller;

import java.util.List;

import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.knowledge.stockonyou.controller.assembler.ProductModelAssembler;
import br.com.knowledge.stockonyou.controller.dto.ProductModel;
import br.com.knowledge.stockonyou.entity.Product;
import br.com.knowledge.stockonyou.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;
    private final ProductModelAssembler assembler;

    public ProductController(ProductService service, ProductModelAssembler assembler) {
        this.service = service;
        this.assembler = assembler;
    }

    @GetMapping
    public CollectionModel<ProductModel> findAll() {
        List<Product> products = service.findAll();
        List<ProductModel> models = products.stream().map(assembler::toModel).toList();

        return CollectionModel.of(models);
    }

    @GetMapping("/{id}")
    public ProductModel findById(@PathVariable Long id) {
        return assembler.toModel(service.findById(id));
    }

    @PostMapping
    public ProductModel create(@RequestBody Product product) {
        Product saved = service.save(product);
        return assembler.toModel(saved);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}