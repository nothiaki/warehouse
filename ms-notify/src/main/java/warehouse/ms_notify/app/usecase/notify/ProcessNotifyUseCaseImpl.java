package warehouse.ms_notify.app.usecase.notify;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import warehouse.ms_notify.app.repository.NotifyRepository;
import warehouse.ms_notify.app.shared.JsonManager;
import warehouse.ms_notify.core.domain.history.History;
import warehouse.ms_notify.core.domain.notify.Notify;
import warehouse.ms_notify.core.usecase.notify.ProcessNotifyUseCase;
import warehouse.ms_notify.core.usecase.saga.SagaSuccessUseCase;

@Service
public class ProcessNotifyUseCaseImpl implements ProcessNotifyUseCase {

  @Autowired
  private SagaSuccessUseCase sagaSuccessUseCase;

  @Autowired
  private NotifyRepository notifyRepository;

  @Autowired
  private JsonManager jsonManager;

  @Override
  public void execute(History history) {

    //it is a mock for the implementation of the notification service

    String content = jsonManager.objectToJson(history.getProducts());

    notifyRepository.save(
      Notify.builder()
      .content(content)
      .notified(true)
      .createdAt(new Date())
      .build()
    );

    sagaSuccessUseCase.execute(history);
  }
  
}
