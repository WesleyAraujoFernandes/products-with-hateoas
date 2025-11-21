package br.com.knowledge.stockonyou.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.knowledge.stockonyou.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
