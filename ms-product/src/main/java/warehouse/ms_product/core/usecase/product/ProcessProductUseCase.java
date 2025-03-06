package warehouse.ms_product.core.usecase.product;

import warehouse.ms_product.core.domain.history.History;

public interface ProcessProductUseCase {

  public void execute(History history);
  
}
