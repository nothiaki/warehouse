package warehouse.api_gateway.core.usecase.product;

import java.util.List;

import warehouse.api_gateway.core.domain.product.Product;

public interface RemoveProductUseCase {

  public void execute(List<Product> products);

}
