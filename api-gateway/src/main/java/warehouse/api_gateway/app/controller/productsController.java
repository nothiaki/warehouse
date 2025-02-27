package warehouse.api_gateway.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import warehouse.api_gateway.core.domain.product.Product;
import warehouse.api_gateway.core.usecase.product.CreateProductUseCase;

@RestController
@RequestMapping("/products")
public class productsController {

  @Autowired
  private CreateProductUseCase createProductUseCase;

  @PostMapping
  public Product create(@RequestBody Product product) {
    return createProductUseCase.execute(product);
  }

}
