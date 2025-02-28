package warehouse.ms_category.core.usecase.history;

import warehouse.ms_category.core.domain.history.History;

public interface ProcessHistoryUseCase {

  public void execute(History history);

}
