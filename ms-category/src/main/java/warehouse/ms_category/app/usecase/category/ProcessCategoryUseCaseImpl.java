package warehouse.ms_category.app.usecase.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import warehouse.ms_category.core.domain.history.History;
import warehouse.ms_category.core.usecase.category.ProcessCategoryUseCase;
import warehouse.ms_category.core.usecase.saga.SagaSuccessUseCase;

@Service
public class ProcessCategoryUseCaseImpl implements ProcessCategoryUseCase {

  @Autowired
  private SagaSuccessUseCase sagaSuccessUseCase;

  @Override
  public void execute(History history) {
    //This is just a mock for process history microservice
    //the idea of this service is take the history
    //and send to a another service that analyze the category data.

    sagaSuccessUseCase.execute(history);

    //if it throw a error
    //it should call the SEC to rollback
  }

}
