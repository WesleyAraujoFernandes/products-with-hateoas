package br.com.knowledge.products_with_hateoas.controller.dto;

import org.springframework.hateoas.RepresentationModel;

import lombok.Getter;
@Getter
public class ProductModel extends RepresentationModel<ProductModel> {
    private Long id;
    private String name;
    private Double price;

}
