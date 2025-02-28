package warehouse.ms_product.core.usecase.product;

import warehouse.ms_product.core.domain.product.Product;

public interface CreateProductUseCase {

  public void execute(Product product);
  
}
