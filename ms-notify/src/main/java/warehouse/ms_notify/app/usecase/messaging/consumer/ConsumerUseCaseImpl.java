package warehouse.ms_notify.app.usecase.messaging.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import warehouse.ms_notify.app.shared.JsonManager;
import warehouse.ms_notify.core.domain.history.History;
import warehouse.ms_notify.core.usecase.messaging.consumer.ConsumerUseCase;
import warehouse.ms_notify.core.usecase.notify.ProcessNotifyUseCase;
import warehouse.ms_notify.infra.config.kafka.KafkaProperties;

@Service
public class ConsumerUseCaseImpl implements ConsumerUseCase {

  @Autowired
  private ProcessNotifyUseCase processNotifyUseCase;

  @Autowired
  private JsonManager jsonManager;

  @Override
  @KafkaListener(
    groupId = KafkaProperties.GROUP_ID,
    topics = KafkaProperties.MS_NOTIFY_PROCESS
  )
  public void execute(String payload) {
    History history = jsonManager.jsonToObject(payload, History.class);

    processNotifyUseCase.execute(history);
  }

}
