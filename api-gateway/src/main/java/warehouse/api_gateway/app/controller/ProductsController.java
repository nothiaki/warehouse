package warehouse.api_gateway.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import warehouse.api_gateway.core.domain.history.History;
import warehouse.api_gateway.core.domain.product.Product;
import warehouse.api_gateway.core.domain.product.ProductRequestDTO;
import warehouse.api_gateway.core.usecase.product.CreateProductUseCase;
import warehouse.api_gateway.core.usecase.product.RemoveProductUseCase;

@RestController
@RequestMapping("/products")
public class ProductsController {

  @Autowired
  private CreateProductUseCase createProductUseCase;

  @Autowired
  private RemoveProductUseCase removeProductUseCase;

  @PostMapping
  public ResponseEntity<List<Product>> create(@RequestBody ProductRequestDTO productRequest) {
    List<Product> responseProducts = createProductUseCase.execute(productRequest);

    return ResponseEntity.status(HttpStatus.ACCEPTED).body(responseProducts);
  }

  @DeleteMapping
  public ResponseEntity<History> remove(@RequestBody ProductRequestDTO productRequest) {
    return ResponseEntity.status(HttpStatus.ACCEPTED)
    .body(
      removeProductUseCase.execute(productRequest.getProducts())
    );
  }

}
