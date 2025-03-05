package warehouse.ms_notify.core.usecase.saga;

import warehouse.ms_notify.core.domain.history.History;

public interface SagaFailUseCase {
  
  public void execute(History history);

}
