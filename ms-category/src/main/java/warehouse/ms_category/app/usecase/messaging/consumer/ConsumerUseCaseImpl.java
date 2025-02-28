package warehouse.ms_category.app.usecase.messaging.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import warehouse.ms_category.app.shared.JsonManager;
import warehouse.ms_category.core.domain.history.History;
import warehouse.ms_category.core.usecase.history.ProcessHistoryUseCase;
import warehouse.ms_category.core.usecase.messaging.consumer.ConsumerUseCase;
import warehouse.ms_category.infra.config.kafka.KafkaProperties;

@Service
public class ConsumerUseCaseImpl implements ConsumerUseCase {

  @Autowired
  private ProcessHistoryUseCase processHistoryUseCase;

  @Autowired
  private JsonManager jsonManager;

  @Override
  @KafkaListener(
    groupId = KafkaProperties.GROUP_ID,
    topics = KafkaProperties.MS_CATEGORY_PROCESS
  )
  public void execute(String payload) {
    History history = jsonManager.jsonToObject(payload, History.class);

    processHistoryUseCase.execute(history);
  }

}
