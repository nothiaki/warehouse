package warehouse.api_gateway.app.usecase.messaging.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import warehouse.api_gateway.app.shared.JsonManager;
import warehouse.api_gateway.core.domain.history.History;
import warehouse.api_gateway.core.usecase.history.FinishHistoryUseCase;
import warehouse.api_gateway.core.usecase.messaging.consumer.ConsumerUseCase;
import warehouse.api_gateway.infra.config.kafka.KafkaProperties;

@Service
public class ConsumerUseCaseImpl implements ConsumerUseCase {

  @Autowired
  private FinishHistoryUseCase finishHistoryUseCase;

  @Autowired
  private JsonManager jsonManager;

  @Override
  @KafkaListener(
    groupId = KafkaProperties.GROUP_ID,
    topics = KafkaProperties.API_GATEWAY_END_SAGA
  )
  public void execute(String payload) {
    History history = jsonManager.jsonToObject(payload, History.class);

    finishHistoryUseCase.execute(history);
  }

}
