package warehouse.ms_product.core.usecase.saga;

import warehouse.ms_product.core.domain.history.History;

public interface SagaSuccessUseCase {
  
  public void execute(History history);

}
