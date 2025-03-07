package warehouse.ms_notify.app.usecase.saga;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import warehouse.ms_notify.app.shared.JsonManager;
import warehouse.ms_notify.core.domain.history.History;
import warehouse.ms_notify.core.domain.history.Operation;
import warehouse.ms_notify.core.domain.history.Status;
import warehouse.ms_notify.core.usecase.messaging.producer.ProducerUseCase;
import warehouse.ms_notify.core.usecase.saga.SagaSuccessUseCase;
import warehouse.ms_notify.infra.config.kafka.KafkaProperties;

@Service
public class SagaSuccessUseCaseImpl implements SagaSuccessUseCase {

  @Autowired
  private ProducerUseCase producerUseCase;

  @Value(KafkaProperties.API_GATEWAY_END_SAGA)
  private String apiGatewayEndSaga;

  @Autowired
  private JsonManager jsonManager;

  @Override
  public void execute(History history) {
    history.getOperations().add(
      Operation.builder()
      .source("MS-NOTIFY")
      .status(Status.FINISHED)
      .build()
    );

    String payload = jsonManager.objectToJson(history);

    producerUseCase.execute(apiGatewayEndSaga, payload);
  }

}
