package br.com.knowledge.products_with_hateoas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.knowledge.products_with_hateoas.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
