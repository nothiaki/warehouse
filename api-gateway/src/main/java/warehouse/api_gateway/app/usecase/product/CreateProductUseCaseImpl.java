package warehouse.api_gateway.app.usecase.product;

import org.springframework.stereotype.Service;

import warehouse.api_gateway.core.domain.product.Product;
import warehouse.api_gateway.core.usecase.product.CreateProductUseCase;

@Service
public class CreateProductUseCaseImpl implements CreateProductUseCase {

  @Override
  public Product execute(Product product) {
    return product;
  }
  
}
