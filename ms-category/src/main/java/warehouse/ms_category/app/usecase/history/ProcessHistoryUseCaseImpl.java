package warehouse.ms_category.app.usecase.history;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import warehouse.ms_category.core.domain.history.History;
import warehouse.ms_category.core.domain.history.Operation;
import warehouse.ms_category.core.domain.history.Status;
import warehouse.ms_category.core.usecase.history.ProcessHistoryUseCase;
import warehouse.ms_category.core.usecase.saga.SagaNextUseCase;

@Service
public class ProcessHistoryUseCaseImpl implements ProcessHistoryUseCase {

  @Autowired
  private SagaNextUseCase sagaNextUseCase;

  @Override
  public void execute(History history) {
    //This is just a mock for process history microservice
    //the idea of this service is take the history
    //and send to a another service that analyze the category data.

    history.getOperations().add(
      Operation.builder()
      .source("MS-CATEGORY")
      .status(Status.FINISHED)
      .build()
    );

    sagaNextUseCase.next(history);

    //if it throw a error
    //it should call the SEC to rollback
  }

}
