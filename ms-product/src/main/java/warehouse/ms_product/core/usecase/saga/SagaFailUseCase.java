package warehouse.ms_product.core.usecase.saga;

import warehouse.ms_product.core.domain.history.History;

public interface SagaFailUseCase {
  
  public void execute(History history);

}
