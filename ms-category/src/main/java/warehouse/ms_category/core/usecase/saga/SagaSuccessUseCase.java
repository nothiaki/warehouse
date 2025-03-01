package warehouse.ms_category.core.usecase.saga;

import warehouse.ms_category.core.domain.history.History;

public interface SagaSuccessUseCase {
  
  public void execute(History history);

}
