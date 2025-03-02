package warehouse.ms_notify.app.usecase.notify;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import warehouse.ms_notify.core.domain.history.History;
import warehouse.ms_notify.core.usecase.notify.ProcessNotifyUseCase;
import warehouse.ms_notify.core.usecase.saga.SagaSuccessUseCase;

@Service
public class ProcessNotifyUseCaseImpl implements ProcessNotifyUseCase {

  @Autowired
  private SagaSuccessUseCase sagaSuccessUseCase;

  @Override
  public void execute(History history) {
    //should create a notify domain
    //should create a notify repository
    //should save a notify in the notify table

    sagaSuccessUseCase.execute(history);
  }
  
}
