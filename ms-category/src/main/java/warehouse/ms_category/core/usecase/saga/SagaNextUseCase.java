package warehouse.ms_category.core.usecase.saga;

import warehouse.ms_category.core.domain.history.History;

public interface SagaNextUseCase {
  
  public void next(History history);

}
