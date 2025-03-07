package warehouse.api_gateway.core.usecase.history;

import java.util.UUID;

import warehouse.api_gateway.core.domain.history.History;

public interface FindOneHistoryUseCase {

  public History execute(UUID id);

}
