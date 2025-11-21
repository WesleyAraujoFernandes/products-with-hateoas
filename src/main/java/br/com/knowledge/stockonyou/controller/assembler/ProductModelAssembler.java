package br.com.knowledge.stockonyou.controller.assembler;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import br.com.knowledge.stockonyou.controller.ProductController;
import br.com.knowledge.stockonyou.controller.dto.ProductModel;
import br.com.knowledge.stockonyou.entity.Product;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@Component
public class ProductModelAssembler extends RepresentationModelAssemblerSupport<Product, ProductModel> {
    public ProductModelAssembler() {
        super(ProductController.class, ProductModel.class);
    }

    @Override
    public ProductModel toModel(Product product) {
        ProductModel model = new ProductModel(product.getId(), product.getName(), product.getPrice());

        model.add(linkTo(methodOn(ProductController.class).findById(product.getId())).withSelfRel());
        model.add(linkTo(methodOn(ProductController.class).findAll()).withRel("products"));

        return model;
    }
}
