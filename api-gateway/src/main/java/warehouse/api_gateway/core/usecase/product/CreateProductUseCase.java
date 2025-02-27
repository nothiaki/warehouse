package warehouse.api_gateway.core.usecase.product;

import warehouse.api_gateway.core.domain.product.Product;

public interface CreateProductUseCase {

  public Product execute(Product product);
  
}
