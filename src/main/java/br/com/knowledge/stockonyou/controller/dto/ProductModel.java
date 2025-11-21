package br.com.knowledge.stockonyou.controller.dto;

import org.springframework.hateoas.RepresentationModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ProductModel extends RepresentationModel<ProductModel> {
    private Long id;
    private String name;
    private Double price;
}
