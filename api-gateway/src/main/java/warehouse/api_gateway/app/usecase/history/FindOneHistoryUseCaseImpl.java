package warehouse.api_gateway.app.usecase.history;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import warehouse.api_gateway.app.repository.HistoryRepository;
import warehouse.api_gateway.core.domain.history.History;
import warehouse.api_gateway.core.usecase.history.FindOneHistoryUseCase;

@Service
public class FindOneHistoryUseCaseImpl implements FindOneHistoryUseCase {

  @Autowired
  private HistoryRepository historyRepository;

  @Override
  public History execute(UUID id) {
    return historyRepository.findById(id)
           .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
  }

}
