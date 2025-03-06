package warehouse.api_gateway.core.usecase.history;

import warehouse.api_gateway.core.domain.history.History;

public interface FinishHistoryUseCase {

  public void execute(History history);

}
