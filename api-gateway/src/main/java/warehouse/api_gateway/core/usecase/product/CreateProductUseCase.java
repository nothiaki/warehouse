package warehouse.api_gateway.core.usecase.product;

import java.util.List;

import warehouse.api_gateway.core.domain.product.Product;
import warehouse.api_gateway.core.domain.product.ProductRequestDTO;

public interface CreateProductUseCase {

  public List<Product> execute(ProductRequestDTO productRequest);
  
}
