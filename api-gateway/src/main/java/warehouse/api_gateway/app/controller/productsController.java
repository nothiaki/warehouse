package warehouse.api_gateway.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import warehouse.api_gateway.core.domain.product.Product;
import warehouse.api_gateway.core.domain.product.RemoveProductRequest;
import warehouse.api_gateway.core.usecase.product.CreateProductUseCase;
import warehouse.api_gateway.core.usecase.product.RemoveProductUseCase;

@RestController
@RequestMapping("/products")
public class productsController {

  @Autowired
  private CreateProductUseCase createProductUseCase;

  @Autowired
  private RemoveProductUseCase removeProductUseCase;

  @PostMapping
  public Product create(@RequestBody Product product) {
    return createProductUseCase.execute(product);
  }

  @DeleteMapping
  public void remove(@RequestBody RemoveProductRequest removeProductRequest) {
    removeProductUseCase.execute(removeProductRequest.getProducts());
  }

}
