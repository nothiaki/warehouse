package warehouse.api_gateway.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import warehouse.api_gateway.core.domain.history.History;
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
  public ResponseEntity<Product> create(@RequestBody Product product) {
    Product responseProduct = createProductUseCase.execute(product);

    return ResponseEntity.ok(responseProduct);
  }

  @DeleteMapping
  public ResponseEntity<History> remove(@RequestBody RemoveProductRequest removeProductRequest) {
    return ResponseEntity.ok(
      removeProductUseCase.execute(removeProductRequest.getProducts())
    );
  }

}
