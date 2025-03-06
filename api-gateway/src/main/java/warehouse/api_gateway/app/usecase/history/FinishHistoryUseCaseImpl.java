package warehouse.api_gateway.app.usecase.history;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import warehouse.api_gateway.app.repository.HistoryRepository;
import warehouse.api_gateway.core.domain.history.History;
import warehouse.api_gateway.core.usecase.history.FinishHistoryUseCase;

@Service
public class FinishHistoryUseCaseImpl implements FinishHistoryUseCase {

  @Autowired
  private HistoryRepository historyRepository;

  @Override
  public void execute(History history) {
    historyRepository.save(history);
  }

}
