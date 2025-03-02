package warehouse.ms_notify.core.usecase.saga;

import warehouse.ms_notify.core.domain.history.History;

public interface SagaSuccessUseCase {
  
  public void execute(History history);

}
