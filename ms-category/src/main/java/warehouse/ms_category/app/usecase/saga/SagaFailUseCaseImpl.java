package warehouse.ms_category.app.usecase.saga;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import warehouse.ms_category.app.shared.JsonManager;
import warehouse.ms_category.core.domain.history.History;
import warehouse.ms_category.core.domain.history.Operation;
import warehouse.ms_category.core.domain.history.Status;
import warehouse.ms_category.core.usecase.messaging.producer.ProducerUseCase;
import warehouse.ms_category.core.usecase.saga.SagaFailUseCase;
import warehouse.ms_category.infra.config.kafka.KafkaProperties;

@Service
public class SagaFailUseCaseImpl implements SagaFailUseCase {

  @Autowired
  private ProducerUseCase producerUseCase;

  @Autowired
  private JsonManager jsonManager;

  @Value(KafkaProperties.API_GATEWAY_SAGA_FAIL)
  private String apiGatewaySagaFail;

  @Override
  public void execute(History history) {
    history.getOperations().add(
      Operation.builder()
      .source("MS-CATEGORY")
      .status(Status.FAILED)
      .createdAt(new Date())
      .build()
    );

    String payload = jsonManager.objectToJson(history);

    producerUseCase.execute(apiGatewaySagaFail, payload);
  }

}
