package warehouse.ms_product.core.usecase.product;

import java.util.List;

import warehouse.ms_product.core.domain.product.Product;

public interface CreateProductUseCase {

  public void execute(List<Product> products);
  
}
